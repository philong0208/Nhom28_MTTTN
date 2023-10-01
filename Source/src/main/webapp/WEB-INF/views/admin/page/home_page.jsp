<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/admin/template"/>
<c:url var="uploadImageUrl" value="/upload/assets/singleFile"/>
<html>
<head>
    <title>Chỉnh sửa page </title>
    <content tag="local_css">
        <link rel="stylesheet" href="https://grapesjs.com/stylesheets/grapes.min.css?v0.18.3">
        <link rel="stylesheet" href="https://grapesjs.com/stylesheets/toastr.min.css">
        <script type="text/javascript" src="https://grapesjs.com/js/toastr.min.js"></script>
        <script type="text/javascript" src="https://unpkg.com/grapesjs@0.18.2/dist/grapes.min.js"></script>
        <script type="text/javascript" src="https://grapesjs.com/js/grapesjs-preset-webpage.min.js?v0.1.11"></script>
        <script type="text/javascript"
                src="https://unpkg.com/grapesjs-blocks-basic@0.1.8/dist/grapesjs-blocks-basic.min.js"></script>
        <style>
            .gjs-editor, gjs-sm-properties, .gjs-layer {
                font-size: 13px !important;
            }
            .gjs-sm-properties {
                font-size: 1rem;
                padding: 10px 5px;
                display: flex;
                flex-wrap: wrap;
                align-items: flex-end;
                box-sizing: border-box;
                width: 100%;
            }
            .gjs-clm-tags {
                font-size: 1rem;
                padding: 10px 5px;
            }
        </style>
    </content>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa Landing page</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div id="gjs"></div>
        </div>
    </div>
</div>

<content tag="local_js">
    <script>
        var origin = window.location.origin;
        var pluginDirectory = origin + `/template/web`;
        const pageData = ${model.content};
        var images = pageData.assets || [];
        // Simple warn notifier
        var origWarn = console.warn;
        toastr.options = {
            closeButton: true,
            preventDuplicates: true,
            showDuration: 250,
            hideDuration: 150
        };
        console.warn = function (msg) {
            if (msg.indexOf('[undefined]') == -1) {
                toastr.warning(msg);
            }
            origWarn(msg);
        };

        var editor = grapesjs.init({
            avoidInlineStyle: 1,
            height: '500px',
            container: '#gjs',
            fromElement: 1,
            showOffsets: 1,
            selectorManager: {componentFirst: true},
            styleManager: {sectors: []},
            assetManager: {
                // Text on upload input
                uploadText: 'Drop files here or click to upload',
                uploadFile: function (e) {
                    var files = e.dataTransfer ? e.dataTransfer.files : e.target.files;
                    var formData = new FormData();
                    formData.append('file', files[0])
                    $.ajax({
                        url: '${uploadImageUrl}',
                        type: 'POST',
                        data: formData,
                        contentType: false,
                        crossDomain: true,
                        mimeType: "multipart/form-data",
                        processData: false,
                        success: function (rs) {
                            const json = JSON.parse(rs);
                            if (json.fileName){
                                editor.AssetManager.add([{
                                    "name": json.fileName,
                                    "type":"image",
                                    "src": json.src,
                                    "status":true,
                                    "message":"Uploaded successfully"
                                }]);
                            }else{
                                alert('Error upload file');
                            }
                        }
                    });
                }
            },
            storageManager: {
                id: 'gjs-',
                type: 'simple-storage',
                autosave: false,
                autoload: false,
            },
            plugins: [
                'grapesjs-lory-slider',
                'grapesjs-tabs',
                'grapesjs-custom-code',
                'grapesjs-touch',
                'grapesjs-parser-postcss',
                'grapesjs-tooltip',
                'grapesjs-tui-image-editor',
                'grapesjs-typed',
                'grapesjs-style-bg',
                'gjs-preset-webpage',
            ],
            pluginsOpts: {
                'grapesjs-tui-image-editor': {
                    script: [
                        // 'https://cdnjs.cloudflare.com/ajax/libs/fabric.js/1.6.7/fabric.min.js',
                        'https://uicdn.toast.com/tui.code-snippet/v1.5.2/tui-code-snippet.min.js',
                        'https://uicdn.toast.com/tui-color-picker/v2.2.7/tui-color-picker.min.js',
                        'https://uicdn.toast.com/tui-image-editor/v3.15.2/tui-image-editor.min.js',
                    ],
                    style: [
                        'https://uicdn.toast.com/tui-color-picker/v2.2.7/tui-color-picker.min.css',
                        'https://uicdn.toast.com/tui-image-editor/v3.15.2/tui-image-editor.min.css'
                    ],
                },
                'grapesjs-lory-slider': {
                    sliderBlock: {
                        category: 'Extra'
                    }
                },
                'grapesjs-tabs': {
                    tabsBlock: {
                        category: 'Extra'
                    }
                },
                'grapesjs-typed': {
                    block: {
                        category: 'Extra',
                        content: {
                            type: 'typed',
                            'type-speed': 40,
                            strings: [
                                'Text row one',
                                'Text row two',
                                'Text row three',
                            ],
                        }
                    }
                },
                'gjs-preset-webpage': {
                    modalImportTitle: 'Import Template',
                    modalImportLabel: '<div style="margin-bottom: 10px; font-size: 13px;">Paste here your HTML/CSS and click Import</div>',
                    modalImportContent: function (editor) {
                        return editor.getHtml() + '<style>' + editor.getCss() + '</style>'
                    },
                    filestackOpts: null, //{ key: 'AYmqZc2e8RLGLE7TGkX3Hz' },
                    aviaryOpts: false,
                    blocksBasicOpts: {flexGrid: 1},
                    customStyleManager: [{
                        name: 'General',
                        properties: [
                            {
                                extend: 'float',
                                type: 'radio',
                                default: 'none',
                                options: [
                                    {value: 'none', className: 'fa fa-times'},
                                    {value: 'left', className: 'fa fa-align-left'},
                                    {value: 'right', className: 'fa fa-align-right'}
                                ],
                            },
                            'display',
                            {extend: 'position', type: 'select'},
                            'top',
                            'right',
                            'left',
                            'bottom',
                        ],
                    }, {
                        name: 'Dimension',
                        open: false,
                        properties: [
                            'width',
                            {
                                id: 'flex-width',
                                type: 'integer',
                                name: 'Width',
                                units: ['px', '%'],
                                property: 'flex-basis',
                                toRequire: 1,
                            },
                            'height',
                            'max-width',
                            'min-height',
                            'margin',
                            'padding'
                        ],
                    }, {
                        name: 'Typography',
                        open: false,
                        properties: [
                            'font-family',
                            'font-size',
                            'font-weight',
                            'letter-spacing',
                            'color',
                            'line-height',
                            {
                                extend: 'text-align',
                                options: [
                                    {id: 'left', label: 'Left', className: 'fa fa-align-left'},
                                    {id: 'center', label: 'Center', className: 'fa fa-align-center'},
                                    {id: 'right', label: 'Right', className: 'fa fa-align-right'},
                                    {id: 'justify', label: 'Justify', className: 'fa fa-align-justify'}
                                ],
                            },
                            {
                                property: 'text-decoration',
                                type: 'radio',
                                default: 'none',
                                options: [
                                    {id: 'none', label: 'None', className: 'fa fa-times'},
                                    {id: 'underline', label: 'underline', className: 'fa fa-underline'},
                                    {id: 'line-through', label: 'Line-through', className: 'fa fa-strikethrough'}
                                ],
                            },
                            'text-shadow'
                        ],
                    }, {
                        name: 'Decorations',
                        open: false,
                        properties: [
                            'opacity',
                            'border-radius',
                            'border',
                            'box-shadow',
                            'background', // { id: 'background-bg', property: 'background', type: 'bg' }
                        ],
                    }, {
                        name: 'Extra',
                        open: false,
                        buildProps: [
                            'transition',
                            'perspective',
                            'transform'
                        ],
                    }, {
                        name: 'Flex',
                        open: false,
                        properties: [{
                            name: 'Flex Container',
                            property: 'display',
                            type: 'select',
                            defaults: 'block',
                            list: [
                                {value: 'block', name: 'Disable'},
                                {value: 'flex', name: 'Enable'}
                            ],
                        }, {
                            name: 'Flex Parent',
                            property: 'label-parent-flex',
                            type: 'integer',
                        }, {
                            name: 'Direction',
                            property: 'flex-direction',
                            type: 'radio',
                            defaults: 'row',
                            list: [{
                                value: 'row',
                                name: 'Row',
                                className: 'icons-flex icon-dir-row',
                                title: 'Row',
                            }, {
                                value: 'row-reverse',
                                name: 'Row reverse',
                                className: 'icons-flex icon-dir-row-rev',
                                title: 'Row reverse',
                            }, {
                                value: 'column',
                                name: 'Column',
                                title: 'Column',
                                className: 'icons-flex icon-dir-col',
                            }, {
                                value: 'column-reverse',
                                name: 'Column reverse',
                                title: 'Column reverse',
                                className: 'icons-flex icon-dir-col-rev',
                            }],
                        }, {
                            name: 'Justify',
                            property: 'justify-content',
                            type: 'radio',
                            defaults: 'flex-start',
                            list: [{
                                value: 'flex-start',
                                className: 'icons-flex icon-just-start',
                                title: 'Start',
                            }, {
                                value: 'flex-end',
                                title: 'End',
                                className: 'icons-flex icon-just-end',
                            }, {
                                value: 'space-between',
                                title: 'Space between',
                                className: 'icons-flex icon-just-sp-bet',
                            }, {
                                value: 'space-around',
                                title: 'Space around',
                                className: 'icons-flex icon-just-sp-ar',
                            }, {
                                value: 'center',
                                title: 'Center',
                                className: 'icons-flex icon-just-sp-cent',
                            }],
                        }, {
                            name: 'Align',
                            property: 'align-items',
                            type: 'radio',
                            defaults: 'center',
                            list: [{
                                value: 'flex-start',
                                title: 'Start',
                                className: 'icons-flex icon-al-start',
                            }, {
                                value: 'flex-end',
                                title: 'End',
                                className: 'icons-flex icon-al-end',
                            }, {
                                value: 'stretch',
                                title: 'Stretch',
                                className: 'icons-flex icon-al-str',
                            }, {
                                value: 'center',
                                title: 'Center',
                                className: 'icons-flex icon-al-center',
                            }],
                        }, {
                            name: 'Flex Children',
                            property: 'label-parent-flex',
                            type: 'integer',
                        }, {
                            name: 'Order',
                            property: 'order',
                            type: 'integer',
                            defaults: 0,
                            min: 0
                        }, {
                            name: 'Flex',
                            property: 'flex',
                            type: 'composite',
                            properties: [{
                                name: 'Grow',
                                property: 'flex-grow',
                                type: 'integer',
                                defaults: 0,
                                min: 0
                            }, {
                                name: 'Shrink',
                                property: 'flex-shrink',
                                type: 'integer',
                                defaults: 0,
                                min: 0
                            }, {
                                name: 'Basis',
                                property: 'flex-basis',
                                type: 'integer',
                                units: ['px', '%', ''],
                                unit: '',
                                defaults: 'auto',
                            }],
                        }, {
                            name: 'Align',
                            property: 'align-self',
                            type: 'radio',
                            defaults: 'auto',
                            list: [{
                                value: 'auto',
                                name: 'Auto',
                            }, {
                                value: 'flex-start',
                                title: 'Start',
                                className: 'icons-flex icon-al-start',
                            }, {
                                value: 'flex-end',
                                title: 'End',
                                className: 'icons-flex icon-al-end',
                            }, {
                                value: 'stretch',
                                title: 'Stretch',
                                className: 'icons-flex icon-al-str',
                            }, {
                                value: 'center',
                                title: 'Center',
                                className: 'icons-flex icon-al-center',
                            }],
                        }]
                    }
                    ],
                },
            },
            canvas: {
                scripts: [
                    'https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js',
                ],
                styles: [
                    pluginDirectory + '/css/plugins/bootstrap.min.css',
                    pluginDirectory + '/css/plugins/fontawesome-all.min.css',
                    pluginDirectory + '/css/plugins/themify-icons.css',
                    pluginDirectory + '/css/plugins/magnific-popup.css',
                    pluginDirectory + '/css/plugins/owl.carousel.css',
                    pluginDirectory + '/css/plugins/default.css',
                    pluginDirectory + '/css/plugins/nav-menu.css',
                    pluginDirectory + '/css/styles.css',
                    pluginDirectory + '/css/home-page.css',
                    origin + `/template/admin/font-awesome/4.5.0/css/font-awesome.min.css`
                ],
            }
        });
        const assetManager = editor.AssetManager
        assetManager.add(JSON.parse(images));
        editor.setComponents(pageData.html);

        var pn = editor.Panels;
        var modal = editor.Modal;
        var cmdm = editor.Commands;
        function save(data) {
            $.ajax({
                url: '${formUrl}',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (res) {
                    toastr.success('Cập nhật giao diện', 'Thành công')
                },
                error: function (res) {
                    toastr.error('Lỗi hệ thống', 'Lỗi!')
                }
            });
        }
        cmdm.add('canvas-clear', function () {
            if (confirm('Are you sure to clean the canvas?')) {
                var comps = editor.DomComponents.clear();
                setTimeout(function () {
                    localStorage.clear()
                }, 0)
            }
        });
        cmdm.add('set-device-desktop', {
            run: function (ed) {
                ed.setDevice('Desktop')
            },
            stop: function () {
            },
        });
        cmdm.add('set-device-tablet', {
            run: function (ed) {
                ed.setDevice('Tablet')
            },
            stop: function () {
            },
        });
        cmdm.add('set-device-mobile', {
            run: function (ed) {
                ed.setDevice('Mobile portrait')
            },
            stop: function () {
            },
        });

        // Add info command
        var mdlClass = 'gjs-mdl-dialog-sm';
        var infoContainer = document.getElementById('info-panel');
        cmdm.add('open-info', function () {
            var mdlDialog = document.querySelector('.gjs-mdl-dialog');
            mdlDialog.className += ' ' + mdlClass;
            infoContainer.style.display = 'block';
            modal.setTitle('About this demo');
            modal.setContent(infoContainer);
            modal.open();
            modal.getModel().once('change:open', function () {
                mdlDialog.className = mdlDialog.className.replace(mdlClass, '');
            })
        });
        pn.addButton('options', {
            id: 'open-info',
            className: 'fa fa-question-circle',
            command: function () {
                editor.runCommand('open-info')
            },
            attributes: {
                'title': 'About',
                'data-tooltip-pos': 'bottom',
            },
        });

        pn.addButton('options', {
            id: 'btn-save',
            className: 'fa fa-save',
            command: function () {
                var data = {};
                const contentTemplate = editor.storeData()
                data["content"] = JSON.stringify(contentTemplate);
                data["name"] = 'LANDING_PAGE';
                data["id"] = 1;
                save(data);
            },
        });

        // Add and beautify tooltips
        [['sw-visibility', 'Show Borders'], ['preview', 'Preview'], ['fullscreen', 'Fullscreen'],
            ['export-template', 'Export'], ['undo', 'Undo'], ['redo', 'Redo'],
            ['gjs-open-import-webpage', 'Import'], ['canvas-clear', 'Clear canvas']]
            .forEach(function (item) {
                pn.getButton('options', item[0]).set('attributes', {title: item[1], 'data-tooltip-pos': 'bottom'});
            });
        [['open-sm', 'Style Manager'], ['open-layers', 'Layers'], ['open-blocks', 'Blocks']]
            .forEach(function (item) {
                pn.getButton('views', item[0]).set('attributes', {title: item[1], 'data-tooltip-pos': 'bottom'});
            });
        var titles = document.querySelectorAll('*[title]');

        for (var i = 0; i < titles.length; i++) {
            var el = titles[i];
            var title = el.getAttribute('title');
            title = title ? title.trim() : '';
            if (!title)
                break;
            el.setAttribute('data-tooltip', title);
            el.setAttribute('title', '');
        }

        // Show borders by default
        pn.getButton('options', 'sw-visibility').set('active', 1);


        // Store and load events
        editor.on('storage:load', function (e) {
            console.log('Loaded ', e)
        });
        editor.on('storage:store', function (e) {
            console.log('Stored ', e)
        });


        // Do stuff on load
        editor.on('load', function () {
            var $ = grapesjs.$;

            // Show logo with the version
            // var logoCont = document.querySelector('.gjs-logo-cont');
            // document.querySelector('.gjs-logo-version').innerHTML = "Landing page";// 'v' + grapesjs.version;
            // var logoPanel = document.querySelector('.gjs-pn-commands');
            // logoPanel.appendChild(logoCont);


            // Load and show settings and style manager
            var openTmBtn = pn.getButton('views', 'open-tm');
            openTmBtn && openTmBtn.set('active', 1);
            var openSm = pn.getButton('views', 'open-sm');
            openSm && openSm.set('active', 1);

            // Add Settings Sector
            var traitsSector = $('<div class="gjs-sm-sector no-select">' +
                '<div class="gjs-sm-sector-title"><span class="icon-settings fa fa-cog"></span> <span class="gjs-sm-sector-label">Settings</span></div>' +
                '<div class="gjs-sm-properties" style="display: none;"></div></div>');
            var traitsProps = traitsSector.find('.gjs-sm-properties');
            traitsProps.append($('.gjs-trt-traits'));
            $('.gjs-sm-sectors').before(traitsSector);
            traitsSector.find('.gjs-sm-sector-title').on('click', function () {
                var traitStyle = traitsProps.get(0).style;
                var hidden = traitStyle.display == 'none';
                if (hidden) {
                    traitStyle.display = 'block';
                } else {
                    traitStyle.display = 'none';
                }
            });

            // Open block manager
            var openBlocksBtn = editor.Panels.getButton('views', 'open-blocks');
            openBlocksBtn && openBlocksBtn.set('active', 1);

        });
    </script>
</content>
</body>
</html>
