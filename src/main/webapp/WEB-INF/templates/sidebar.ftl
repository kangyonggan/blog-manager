<div id="sidebar" class="sidebar responsive sidebar-fixed sidebar-scroll" data-sidebar="true" data-sidebar-scroll="true"
     data-sidebar-hover="true">
    <div class="nav-wrap-up pos-rel">
        <div class="nav-wrap" style="max-height: 192px;">
            <div style="position: relative; top: 0px; transition-property: top; transition-duration: 0.15s;">
                <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                        <button class="btn btn-success">
                            <i class="ace-icon fa fa-signal"></i>
                        </button>

                        <button class="btn btn-info">
                            <i class="ace-icon fa fa-pencil"></i>
                        </button>

                        <button class="btn btn-warning">
                            <i class="ace-icon fa fa-users"></i>
                        </button>

                        <button class="btn btn-danger">
                            <i class="ace-icon fa fa-cogs"></i>
                        </button>

                    </div>

                    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                        <span class="btn btn-success"></span>

                        <span class="btn btn-info"></span>

                        <span class="btn btn-warning"></span>

                        <span class="btn btn-danger"></span>
                    </div>
                </div>
                <ul class="nav nav-list" style="top: 0px;">
                    <li id="dashboard" class="">
                        <a href="${ctx}/">
                            <i class="menu-icon fa fa-tachometer"></i>
                            <span class="menu-text"> 工作台 </span>
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li id="blog-manager">
                        <a href="javascript:" class="dropdown-toggle">
                            <i class="menu-icon fa fa-code"></i>
                            <span class="menu-text"> 博客管理 </span>

                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu nav-show" style="display: block;">
                            <li id="category-manager">
                                <a href="${ctx}/category">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    栏目管理
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li id="article-manager" >
                                <a href="${ctx}/article">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    文章管理
                                </a>

                                <b class="arrow"></b>
                            </li>

                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>
