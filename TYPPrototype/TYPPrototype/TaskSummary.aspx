﻿<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="TaskSummary.aspx.cs" Inherits="TYPPrototype.TaskSummary" %>
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
                                    <li class="breadcrumb-item active">Task Summary
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
        <div class="content-wrapper">
            <div class="content-detached content-right">
                <div class="content-body">
                    <section class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">All Bugs</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-h font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <button class="btn btn-primary btn-sm"><i class="ft-plus white"></i>Submit Bug</button>
                                        <span class="dropdown">
                                            <button id="btnSearchDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-warning btn-sm dropdown-toggle dropdown-menu-right"><i class="ft-download white"></i></button>
                                            <span aria-labelledby="btnSearchDrop1" class="dropdown-menu mt-1 dropdown-menu-right">
                                                <a href="#" class="dropdown-item"><i class="la la-calendar"></i>Due Date</a>
                                                <a href="#" class="dropdown-item"><i class="la la-random"></i>Priority </a>
                                                <a href="#" class="dropdown-item"><i class="la la-bar-chart"></i>Progress</a>
                                                <a href="#" class="dropdown-item"><i class="la la-user"></i>Assign to</a>
                                            </span>
                                        </span>
                                        <button class="btn btn-success btn-sm"><i class="ft-settings white"></i></button>
                                    </div>
                                </div>
                                <div class="card-content">
                                    <div class="card-body">
                                        <!-- Task List table -->
                                        <div class="table-responsive">
                                            <table id="project-bugs-list" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Bug</th>
                                                        <th>Asignee</th>
                                                        <th>Status</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#101</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Vertical menu issue on iPad</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-3.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="John Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-info">In Progress</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop2" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop2" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#220</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Progress bar animation improvement</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-4.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Amy Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-warning">Open</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop3" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop3" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#420</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Authentication API security issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-5.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-danger">Reopen</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop4" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop4" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#124</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Project page chart issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-16.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-info">In Progress</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop5" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop5" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#140</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Profile page timeline issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-success">To be tested</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop6" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop6" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#261</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Tooltip display issue in login form</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-8.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-warning">Open</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop7" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop7" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#158</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Button loading issue on submit</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-9.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-info">Closed</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop8" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop8" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#158</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">D3 Chart responsive issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-10.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-danger">Reopen</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop9" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop9" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#850</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Google map reset location</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-11.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-warning">Open</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop10" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop10" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#550</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">jQuery drag and drop integration issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-12.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-info">In Progress</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop11" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop11" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#425</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">DataTable inline editable issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-14.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-danger">Reopen</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop12" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop12" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#526</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Vertical menu issue on iPad</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-3.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="John Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-info">In Progress</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop13" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop13" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#995</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Progress bar animation improvement</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-4.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Amy Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-warning">Open</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop14" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop14" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#992</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Authentication API security issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-5.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-danger">Reopen</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop15" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop15" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="#" class="text-bold-600">#956</a></td>
                                                        <td>
                                                            <a href="#" class="text-bold-600">Project page chart issue</a>
                                                            <p class="text-muted font-small-2">Phasellus vel elit volutpat, egestas urna a.</p>
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="avatar avatar-busy">
                                                                <img src="../../../app-assets/images/portrait/small/avatar-s-16.png" alt="avatar" data-toggle="tooltip" data-placement="right" title="Joe Doe"><i class=""></i>
                                                            </span>
                                                        </td>
                                                        <td><span class="badge badge-info">In Progress</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop16" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop16" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i>Open Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i>Edit Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-check"></i>Complete Bug</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-upload"></i>Assign to</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i>Delete Bug</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Bug</th>
                                                        <th>Asignee</th>
                                                        <th>Status</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>

        <div class="sidebar-detached sidebar-left">
            <div class="sidebar">
                <div class="bug-list-sidebar-content">
                    <!-- Predefined Views -->
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Predefined Views</h4>
                            <a class="heading-elements-toggle"><i class="la la-ellipsis-h font-medium-3"></i></a>
                            <div class="heading-elements">
                                <ul class="list-inline mb-0">
                                    <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                    <li><a data-action="close"><i class="ft-x"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- bug-list search -->
                        <div class="card-content collapse show">
                            <div class="card-body border-top-blue-grey border-top-lighten-5">
                                <div class="bug-list-search">
                                    <div class="bug-list-search-content">
                                        <form action="#">
                                            <div class="position-relative">
                                                <input type="search" class="form-control" placeholder="Search project bugs...">
                                                <div class="form-control-position">
                                                    <i class="ft-search text-size-base text-muted"></i>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- /bug-list search -->

                            <!-- bug-list view -->
                            <div class="card-body ">
                                <div class="list-group">
                                    <a href="#" class="list-group-item active">All Bugs</a>
                                    <a href="#" class="list-group-item list-group-item-action">All Open</a>
                                    <a href="#" class="list-group-item list-group-item-action">All Closed</a>
                                    <a href="#" class="list-group-item list-group-item-action">My Open</a>
                                    <a href="#" class="list-group-item list-group-item-action">My Closed</a>
                                    <a href="#" class="list-group-item list-group-item-action">Overdue Bugs</a>
                                    <a href="#" class="list-group-item list-group-item-action disabled">Created Today</a>
                                    <a href="#" class="list-group-item list-group-item-action">Bugs I Follow</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--/ Predefined Views -->
                </div>
            </div>
        </div>
    </div>
       <!-- ************************************************************************************************** -->
</asp:Content>
