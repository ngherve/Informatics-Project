<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="Bins.aspx.cs" Inherits="TYPPrototype.Bins" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="app-content content">
         <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Stock Management</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Location.aspx">Location</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Warehouses</a>
                                    </li>
                                    <li class="breadcrumb-item active">Bins
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
            <div class="content-body">
                 <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">All Bins</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-h font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <button class="btn btn-primary btn-sm"><i class="ft-plus white"></i> Add Bin</button>
                                        <span class="dropdown">
                                            <button id="btnSearchDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-warning btn-sm dropdown-toggle dropdown-menu-right"><i class="ft-download white"></i></button>
                                            <span aria-labelledby="btnSearchDrop1" class="dropdown-menu mt-1 dropdown-menu-right">
                                                <a href="#" class="dropdown-item"><i class="la la-calendar"></i> Due Date</a>
                                                <a href="#" class="dropdown-item"><i class="la la-random"></i> Priority </a>
                                                <a href="#" class="dropdown-item"><i class="la la-bar-chart"></i> Progress</a>
                                                <a href="#" class="dropdown-item"><i class="la la-user"></i> Status</a>
                                            </span>
                                        </span>
                                        <button class="btn btn-success btn-sm"><i class="ft-settings white"></i></button>
                                    </div>
                                </div>
                                <div class="card-content">
                                    <div class="card-body">
                                        <!-- Task List table -->
                                        <div class="table-responsive">
                                           <table id="new-orders-table" class="table table-hover table-bordered row-grouping table-xl mb-0">
                                                <thead>
                                                    <tr> 
                                                    <th class="border-top-0">Bin ID</th>
                                                    <th class="border-top-0">Status</th>
                                                    <th class="border-top-0">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="text-truncate">A01</td>
                                                        <td><span class="badge badge-success">Empty</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop2" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop2" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i> View Products</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i> Edit Content</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i> Delete Bin</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        
                                                        <td class="text-truncate">A02</td>
                                                        <td><span class="badge badge-danger">Full</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop3" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop3" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i> View Products</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i> Edit Content</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i> Delete Bin</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        
                                                       <td class="text-truncate">A03</td>
                                                        <td><span class="badge badge-danger">Full</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop4" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop4" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i> View Products</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i> Edit Content</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i> Delete Bin</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        
                                                       <td class="text-truncate">A04</td>
                                                        <td><span class="badge badge-success">Empty</span></td>

                                                        <td>
                                                            <span class="dropdown">
                                                                <button id="btnSearchDrop16" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-info dropdown-toggle"><i class="la la-cog"></i></button>
                                                                <span aria-labelledby="btnSearchDrop16" class="dropdown-menu mt-1 dropdown-menu-right">
                                                                    <a href="#" class="dropdown-item"><i class="ft-eye"></i> View Products</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-edit-2"></i> Edit Content</a>
                                                                    <a href="#" class="dropdown-item"><i class="ft-trash"></i> Delete Bin</a>
                                                                </span>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        
                                                        <th>Bin ID</th>
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
        </div>
    </div>

    <!-- ************************************************************************************************** -->
    <!-- Dashboard CSS -->
        <script src="app-assets/vendors/js/material-vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <script src="app-assets/vendors/js/charts/chartist.min.js"></script>
    <script src="app-assets/vendors/js/charts/chartist-plugin-tooltip.min.js"></script>
    <script src="app-assets/vendors/js/charts/raphael-min.js"></script>
    <script src="app-assets/vendors/js/charts/morris.min.js"></script>
    <script src="app-assets/vendors/js/timeline/horizontal-timeline.js"></script>
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="app-assets/js/core/app-menu.js"></script>
    <script src="app-assets/js/core/app.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="app-assets/js/scripts/pages/material-app.js"></script>
    <script src="app-assets/js/scripts/pages/dashboard-ecommerce.js"></script>

    <!-- Dashboard CSS -->
    <!-- ************************************************************************************************** -->
</asp:Content>
