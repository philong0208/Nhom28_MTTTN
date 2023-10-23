package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByCreatedBy(String createdBy);
    List<PostEntity> findTop4ByHotPostOrderByCreatedDateDesc(String hotPost);
    List<PostEntity> findBySlideConfigurationOrderBySlideConfigurationNumberAsc(String value);
    List<PostEntity> findByMenuConfigurationOrderByMenuConfigurationNumber(String value);
    PostEntity findBySeoUrl(String seoUrl);
    Page<PostEntity> findByShortTitleContainingIgnoreCase(String shortTitle, Pageable pageable);
    Page<PostEntity> findByShortTitleContainingIgnoreCaseAndCreatedBy(String shortTitle, String createdBy, Pageable pageable);
    long countByShortTitleContainingIgnoreCase(String shortTitle);
    long countByShortTitleContainingIgnoreCaseAndCreatedBy(String shortTitle, String createdBy);
    Page<PostEntity> findByBlogConfigurationAndShortTitleContainingIgnoreCase(String blogConfig, String shortTitle, Pageable pageable);
    long countByBlogConfigurationAndShortTitleContainingIgnoreCase(String blogConfig, String shortTitle);
    Page<PostEntity> findBySeoUrlContainingIgnoreCase(String seoUrl, Pageable pageable);
    long countBySeoUrlContainingIgnoreCase(String seoUrl);
    Page<PostEntity> findByCategory_CodeOrderByCreatedDateAsc(String code, Pageable pageable);
    long countByCategory_Code(String code);
    PostEntity findByShortUrl(String shortUrl);
    List<PostEntity> findByCategory_Id(Long id);
    List<PostEntity> findByTags_Id(Long id);

    List<PostEntity> findByAuthors_Id(Long id);
    boolean existsByShortTitleIgnoreCase(String shortTitle);
    boolean existsByShortTitleIgnoreCaseAndIdNot(String shortTitle, long id);
    void deleteAllByIdIn(long[] ids);
    List<PostEntity> findTop6ByOrderByViewDesc();
    List<PostEntity> findTop6ByOrderByCreatedDateDesc();
    List<PostEntity> findTop6ByOrderByScoreDesc();
}
