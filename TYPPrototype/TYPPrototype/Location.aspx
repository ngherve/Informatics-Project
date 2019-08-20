<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="Location.aspx.cs" Inherits="TYPPrototype.Location" %>
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
                                    <li class="breadcrumb-item"><a href="dashboard.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Location</a>
                                    </li>
                                    <li class="breadcrumb-item active">Warehouses
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
                  <div class="row">
                        <div class="col-xl-4 col-lg-6">
                            <div class="card">
                                <div class="card-content">
                                    <div class="card-body text-center">
                                        <p class="text-uppercase">Warehouse 1</p>
                                        <h3 class="text-uppercase">Mechanical Products</h3>
                                        <div class="rating">
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star-half-o"></i>
                                        </div>
                                        <img src="../../../app-assets/images/elements/apple-watch.png" alt="apple-watch" width="250px" class="img-fluid p-2">
                                        <button type="button" class="btn btn-success btn-block btn-glow text-uppercase p-1">View</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-6">
                            <div class="card">
                                <div class="card-content">
                                    <div class="card-body text-center">
                                        <p class="text-uppercase">Warehouse 2</p>
                                        <h3 class="text-uppercase">Industrial Products</h3>
                                        <div class="rating">
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star-half-o"></i>
                                        </div>
                                        <img src="../../../app-assets/images/elements/fitbit-watch.png" alt="apple-watch" width="250px" class="img-fluid p-2">
            

                                         <asp:Button ID="btnView1" runat="server" Text="View" BorderStyle="Solid" ToolTip="Submit" class="btn btn-success btn-block btn-glow text-uppercase p-1" OnClick="btnView1_Click"  />  

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-6">
                            <div class="card">
                                <div class="card-content">
                                    <div class="card-body text-center">
                                        <p class="text-uppercase">Warehouse 3</p>
                                        <h3 class="text-uppercase">Electrical Products</h3>
                                        <div class="rating">
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star"></i>
                                            <i class="la la-star-half-o"></i>
                                        </div>
                                        <img src="../../../app-assets/images/elements/samsung-gear.png" alt="apple-watch" width="250px" class="img-fluid p-2">
                                        <button type="button" class="btn btn-success btn-block btn-glow text-uppercase p-1">View</button>
                                    </div>
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
    <script src="../../../app-assets/vendors/js/charts/echarts/echarts.js"></script>
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="../../../app-assets/js/core/app-menu.js"></script>
    <script src="../../../app-assets/js/core/app.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="../../../app-assets/js/scripts/pages/material-app.js"></script>
    <script src="../../../app-assets/js/scripts/cards/card-ecommerce.js"></script>
    <!-- END: Page JS-->


</asp:Content>
