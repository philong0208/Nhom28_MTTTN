package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.PostConverter;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.AuthorEntity;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.entity.TagEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.repository.TagRepository;
import com.laptrinhjavaweb.service.IAuthorService;
import com.laptrinhjavaweb.service.IPostService;
import com.laptrinhjavaweb.service.ITagService;
import com.laptrinhjavaweb.utils.UploadFileUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;

    @Value("${dir.default}")
    private String dirDefault;
    @Override
    public List<PostDTO> findAll(String shortTitle, Pageable pageable) {
        return postRepository.findByShortTitleContainingIgnoreCase(shortTitle,
                        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                                Sort.by("modifiedDate").descending()))
                .getContent().stream().map(item -> postConverter.convertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public int getTotalItems(String shortTitle) {
        return (int) postRepository.countByShortTitleContainingIgnoreCase(shortTitle);
    }
    @Autowired
    private ITagService tagService;
    @Autowired
    private IAuthorService authorService;

    @Override
    @Transactional
    public PostDTO insert(PostDTO postDTO) {
        try {
            PostEntity postEntity = postConverter.convertToEntity(postDTO);
            postEntity.setCategory(categoryRepository.findOneByCode(postDTO.getCategoryCode()));
            /*postEntity.getTags().addAll(Arrays.stream(postDTO.getTagCodeArray())
                    .map(tagRepository::findOneByCode)
                    .collect(Collectors.toList()));*/
            Map<String, TagEntity> tagMap = tagService.getTagEntity();
            postEntity.getTags().addAll(
                    Arrays.asList(postDTO.getTagCodeArray()).stream().map(tagMap::get)
                            .collect(Collectors.toList()));
            Map<String, AuthorEntity> authorMap = authorService.getAuthorEntity();
            postEntity.getAuthors().addAll(
                    Arrays.asList(postDTO.getAuthorCodeArray()).stream().map(authorMap::get)
                            .collect(Collectors.toList()));
            saveThumbnail(postDTO, postEntity);
            saveOgImage(postDTO, postEntity);
            postEntity = postRepository.save(postEntity);
            return postConverter.convertToDto(postEntity);
        } catch (Exception e) {
            return new PostDTO();
        }
    }

    @Override
    @Transactional
    public PostDTO update(PostDTO postDTO) {
        try {
            PostEntity existsPost = postRepository.findById(postDTO.getId()).get();
            PostEntity updatePost = postConverter.convertToEntity(postDTO);
            updatePost.setCreatedBy(existsPost.getCreatedBy());
            updatePost.setCreatedDate(existsPost.getCreatedDate());
            if (existsPost.getModifiedBy() != null) {
                updatePost.setModifiedBy(existsPost.getModifiedBy());
            }
            if (existsPost.getModifiedDate() != null) {
                updatePost.setModifiedDate(existsPost.getModifiedDate());
            }
            updatePost.setThumbnail(existsPost.getThumbnail());
            updatePost.setOgImage(existsPost.getOgImage());
            updatePost.setCategory(categoryRepository.findOneByCode(postDTO.getCategoryCode()));
            /*updatePost.getTags().addAll(Arrays.stream(postDTO.getTagCodeArray())
                    .map(tagRepository::findOneByCode)
                    .collect(Collectors.toList()));*/
            Map<String, TagEntity> tagMap = tagService.getTagEntity();
            updatePost.getTags().addAll(
                    Arrays.asList(postDTO.getTagCodeArray()).stream().map(tagMap::get)
                            .collect(Collectors.toList()));
            Map<String, AuthorEntity> authorMap = authorService.getAuthorEntity();
            updatePost.getAuthors().addAll(
                    Arrays.asList(postDTO.getAuthorCodeArray()).stream().map(authorMap::get)
                            .collect(Collectors.toList()));
            saveThumbnail(postDTO, updatePost);
            saveOgImage(postDTO, updatePost);
            postRepository.save(updatePost);
            return postConverter.convertToDto(updatePost);
        } catch (Exception e) {
            return postDTO;
        }
    }

    @Override
    @Transactional
    public void deletePost(long[] ids) {
        for (long item : ids) {
            postRepository.deleteById(item);
        }
    }

    @Override
    public PostDTO findById(long id) {
        PostEntity postEntity = postRepository.findById(id).get();
        return postConverter.convertToDto(postEntity);
    }

    @Override
    public List<PostDTO> findByHotPost(String value) {
        List<PostEntity> postEntities = postRepository.findTop4ByHotPostOrderByCreatedDateDesc(value);
        return postEntities.stream().map(item -> postConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findBySlidePost(String value) {
        List<PostEntity> postEntities = postRepository.findBySlideConfigurationOrderBySlideConfigurationNumberAsc("YES");
        return postEntities.stream().map(item -> postConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findByMenuConfiguration(String value) {
        List<PostEntity> postEntities = postRepository.findByMenuConfigurationOrderByMenuConfigurationNumber("YES");
        return postEntities.stream().map(item -> postConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public PostDTO findBySeoUrl(String seoUrl) {
        PostEntity postEntity = new PostEntity();
        if (postRepository.findBySeoUrl(seoUrl) != null) {
            postEntity = postRepository.findBySeoUrl(seoUrl);
        }
        return postConverter.convertToDto(postEntity);
    }

    @Override
    public List<PostDTO> findAllTalk(Pageable pageable) {
        List<PostEntity> results = postRepository.findBySeoUrlContainingIgnoreCase(SystemConstant.TALK_SEO_URL, pageable).getContent();
        return results.stream().map(item -> postConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public int getTotalItemsTalk() {
        return (int) postRepository.countBySeoUrlContainingIgnoreCase(SystemConstant.TALK_SEO_URL);
    }

    @Override
    public List<PostDTO> findByCategory(String code, Pageable pageable) {
        List<PostEntity> postEntities = postRepository.findByCategory_CodeOrderByCreatedDateAsc(code, pageable).getContent();
        return postEntities.stream().map(item -> postConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public int getTotalItemsByCategory(String code) {
        return (int) postRepository.countByCategory_Code(code);
    }

    @Override
    public PostDTO findByShortUrl(String shortUrl) {
        PostEntity postEntity = new PostEntity();
        if (postRepository.findByShortUrl(shortUrl) != null) {
            postEntity = postRepository.findByShortUrl(shortUrl);
        }
        return postConverter.convertToDto(postEntity);
    }

    private void saveOgImage(PostDTO postDTO, PostEntity postEntity) {
        String path = SystemConstant.POST_IMAGE + "/" + postDTO.getOgImageName();
        if (postDTO.getOgImageBase64() != null) {
            if (postEntity.getOgImage() != null) {
                if (!path.equals(postEntity.getOgImage())) {
                    File file = new File(dirDefault + postEntity.getOgImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(postDTO.getOgImageBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            postEntity.setOgImage(path);
        }
    }

    private void saveThumbnail(PostDTO postDTO, PostEntity postEntity) {
        String path = SystemConstant.POST_IMAGE + "/" + postDTO.getThumbnailImageName();
        if (postDTO.getThumbnailBase64() != null) {
            if (postEntity.getThumbnail() != null) {
                if (!path.equals(postEntity.getThumbnail())) {
                    File file = new File(dirDefault + postEntity.getThumbnail());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(postDTO.getThumbnailBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            postEntity.setThumbnail(path);
        }
    }
}
