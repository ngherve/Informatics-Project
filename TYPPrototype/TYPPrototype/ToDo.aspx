<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="ToDo.aspx.cs" Inherits="TYPPrototype.ToDo" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
     <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Warehouse Management</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="dashboard.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Tasks</a>
                                    </li>
                                    <li class="breadcrumb-item active">To Do List
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <div class="sidebar-left">
            <div class="sidebar">
                <div class="sidebar-content sidebar-todo">
                    <div class="card">
                        <div class="card-body">
                            <div class="form-group form-group-compose text-center">
                                <button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#AddTaskModal">
                                    Add Task
                                </button>
                            </div>
                            <h6 class="text-muted text-bold-500 my-1">Messages</h6>
                            <div class="list-group list-group-messages">
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-home mr-1"></i>
                                    <span>Home</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-list mr-1"></i>
                                    <span>My Tasks</span><span class="badge badge-secondary badge-pill float-right">8</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-bell mr-1"></i>
                                    <span>Inbox</span>
                                    <span class="badge badge-danger badge-pill float-right">3</span> </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-screen-desktop mr-1"></i>
                                    <span>Dashboard</span>
                                </a>
                            </div>
                            <h6 class="text-muted text-bold-500 my-1">Filters</h6>
                            <div class="list-group list-group-messages">
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-star mr-1"></i>
                                    <span>Starred</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-energy mr-1"></i>
                                    <span>Priority</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-clock mr-1"></i>
                                    <span>Scheduled</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-calendar mr-1"></i>
                                    <span>Today</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-check mr-1"></i>
                                    <span>Completed</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="icon-close mr-1"></i>
                                    <span>Deleted</span>
                                </a>
                            </div>
                            <h6 class="text-muted text-bold-500 my-1">Tags</h6>
                            <div class="list-group list-group-messages">
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="ft-circle mr-1 warning"></i>
                                    <span> Project </span> <span class="badge badge-warning badge-pill float-right">5</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="ft-circle mr-1 secondary"></i>
                                    <span> Product </span> <span class="badge badge-secondary badge-pill float-right">1</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="ft-circle mr-1 primary"></i>
                                    <span> Bug </span> <span class="badge badge-primary badge-pill float-right">2</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="ft-circle mr-1 success"></i>
                                    <span> API </span> <span class="badge badge-success badge-pill float-right">3</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action border-0">
                                    <i class="ft-circle mr-1 danger"></i>
                                    <span> UI </span> <span class="badge badge-danger badge-pill float-right">1</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-right">
            <div class="content-header row">
            </div>
            <div class="content-wrapper">
                <div class="content-body">
                    <div class="content-overlay"></div>
                    <!-- Modal -->
                    <div class="modal" id="AddTaskModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <section class="todo-form">
                                    <form id="form-add-todo" class="todo-input">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Add New Task</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <fieldset class="form-group col-12">
                                                <input type="text" id="new-todo-item" class="new-todo-item form-control" placeholder="Todo Title">
                                            </fieldset>
                                            <fieldset class="form-group col-12">
                                                <select class="custom-select" id="todo-select">
                                                    <option selected>Select Tag</option>
                                                    <option value="warning">Project</option>
                                                    <option value="secondary">Product</option>
                                                    <option value="primary">Bug</option>
                                                    <option value="success">API</option>
                                                    <option value="danger">UI</option>
                                                </select>
                                            </fieldset>
                                            <fieldset class="form-group position-relative has-icon-left col-12">
                                                <div class="form-control-position">
                                                    <i class="icon-emoticon-smile"></i>
                                                </div>
                                                <input type="text" id="new-todo-desc" class="new-todo-desc form-control" placeholder="Todo Description">
                                                <div class="form-control-position control-position-right">
                                                    <i class="ft-image"></i>
                                                </div>
                                            </fieldset>
                                        </div>
                                        <div class="modal-footer">
                                            <fieldset class="form-group position-relative has-icon-left mb-0">
                                                <button type="button" id="add-todo-item" class="btn btn-info add-todo-item" data-dismiss="modal"><i class="la la-paper-plane-o d-lg-none"></i>
                                                    <span class="d-none d-lg-block">Add New</span></button>
                                            </fieldset>
                                        </div>
                                    </form>
                                </section>
                            </div>
                        </div>
                    </div>
                    <div class="card todo-details rounded-0">
                        <div class="sidebar-toggle d-block d-lg-none"><i class="ft-menu font-large-1"></i></div>
                        <div class="search">
                            <input id="basic-search" type="text" placeholder="Search here..." class="basic-search">
                            <i class="ficon ft-search"></i>
                        </div>
                        <div class="card-content">
                            <div class="card-body">
                                <form id="form-todo-list">
                                    <div id="todo-list" class="todo-list media-list media-bordered">
                                        <div class="todo-item media">
                                            <div class="media-left pr-1">
                                                <span class="dragme ft-more-vertical"></span>
                                                <input type='checkbox' name='todo-item-done' class='todo-item-done' />
                                            </div>
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    Brownie marzipan gingerbread cake muffin
                                                    <div class="float-right">
                                                        <span class="mr-2 badge badge-warning">Project</span>
                                                        <a class='todo-item-delete'><i class="la la-trash"></i></a>
                                                    </div>
                                                </div>
                                                <span class="todo-desc">Oat cake biscuit liquorice biscuit cookie chocolate marshmallow dragée.</span>
                                            </div>
                                        </div>
                                        <div class="todo-item media">
                                            <div class="media-left pr-1">
                                                <span class="dragme ft-more-vertical"></span>
                                                <input type='checkbox' name='todo-item-done' class='todo-item-done' />
                                            </div>
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    Ice cream toffee pudding caramels donut ice cream
                                                    <div class="float-right">
                                                        <a class='todo-item-delete'><i class="la la-trash"></i></a>
                                                    </div>
                                                </div>
                                                <span class="todo-desc">Chocolate bar chupa chups biscuit. Icing pudding cake caramels halvah.</span>
                                            </div>
                                        </div>
                                        <div class="todo-item media">
                                            <div class="media-left pr-1">
                                                <span class="dragme ft-more-vertical"></span>
                                                <input type='checkbox' name='todo-item-done' class='todo-item-done' />
                                            </div>
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    Danish liquorice candy lemon drops gingerbread
                                                    <div class="float-right">
                                                        <span class="mr-2 badge badge-secondary">Product</span>
                                                        <a class='todo-item-delete'><i class="la la-trash"></i></a>
                                                    </div>
                                                </div>
                                                <span class="todo-desc">Jelly beans sesame snaps wafer sweet roll. Biscuit tart pastry lemon drops brownie.</span>
                                            </div>
                                        </div>
                                        <div class="todo-item media">
                                            <div class="media-left pr-1">
                                                <span class="dragme ft-more-vertical"></span>
                                                <input type='checkbox' name='todo-item-done' class='todo-item-done' />
                                            </div>
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    Chocolate macaroon oat cake pudding marzipan
                                                    <div class="float-right">
                                                        <a class='todo-item-delete'><i class="la la-trash"></i></a>
                                                    </div>
                                                </div>
                                                <span class="todo-desc">Sweet tart cake jujubes. Jelly beans carrot cake sugar plum candy dessert.</span>
                                            </div>
                                        </div>
                                        <div class="todo-item media">
                                            <div class="media-left pr-1">
                                                <span class="dragme ft-more-vertical"></span>
                                                <input type='checkbox' name='todo-item-done' class='todo-item-done' />
                                            </div>
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    Toffee biscuit muffin toffee tootsie roll macaroon
                                                    <div class="float-right">
                                                        <span class="mr-2 badge badge-danger">UI</span>
                                                        <a class='todo-item-delete'><i class="la la-trash"></i></a>
                                                    </div>
                                                </div>
                                                <span class="todo-desc">Tootsie roll caramels tart chupa chups tiramisu lollipop. Tiramisu soufflé bonbon.</span>
                                            </div>
                                        </div>
                                        <div class="todo-item media">
                                            <div class="media-left pr-1">
                                                <span class="dragme ft-more-vertical"></span>
                                                <input type='checkbox' name='todo-item-done' class='todo-item-done' />
                                            </div>
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    Powder chocolate fruitcake apple pie marshmallow
                                                    <div class="float-right">
                                                        <a class='todo-item-delete'><i class="la la-trash"></i></a>
                                                    </div>
                                                </div>
                                                <span class="todo-desc">Chocolate cookie tart apple pie cake cupcake gingerbread fruitcake cookie.</span>
                                            </div>
                                        </div>
                                        <div class="todo-item no-result text-center media no-items">
                                            <div class="media-body">
                                                <div class="todo-title">
                                                    No items found
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  
      </div>

       <!-- BEGIN: Vendor JS-->
    <script src="../../../app-assets/vendors/js/material-vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <script src="../../../app-assets/vendors/js/forms/icheck/icheck.min.js"></script>
    <script src="../../../app-assets/vendors/js/extensions/dragula.min.js"></script>
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="../../../app-assets/js/core/app-menu.js"></script>
    <script src="../../../app-assets/js/core/app.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="../../../app-assets/js/scripts/pages/material-app.js"></script>
    <script src="../../../app-assets/js/scripts/pages/app-todo.js"></script>
    <!-- END: Page JS-->



</asp:Content>
