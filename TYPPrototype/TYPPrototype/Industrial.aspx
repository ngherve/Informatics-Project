<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="Industrial.aspx.cs" Inherits="TYPPrototype.Industrial" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
     <body>
    
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title">User Cards</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="Industrial.aspx">View Products</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Industrial Product Records
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-wrapper">

            
            <div class="content-body"> 
                <!-- User Profile Cards -->
                <section id="user-profile-cards" class="row mt-2">
                    <div class="col-12">
                        <h4 class="text-uppercase">Industrial Product Records</h4>
                    </div>
                    <div class="col-xl-4 col-md-6 col-12">
                        <div class="card">
                            <div class="text-center">
                                <div class="card-body">
                                    <img src="../../../app-assets/images/portrait/medium/avatar-m-4.png" class="rounded-circle  height-150" alt="Card image">
                                </div>
                                <div class="card-body">
                                    <h4 class="card-title">Warehouse Number</h4>
                                    <h6 class="card-subtitle text-muted">Bin Number</h6>
                                </div>
                                <div class="card-body">
                                    <button type="button"   class="btn btn-danger mr-1"><i class="la la-plus"></i> Edit</button>
                                    <button type="button" class="btn btn-primary mr-1"><i class="ft-user"></i> Remove</button>
                                </div>
                            </div>
                            <div class="list-group list-group-flush">
                                <a href="contactSupplier" class="list-group-item"><i class="ft-mail"></i> Contact Spplier</a>
                                <a href="viewStock" class="list-group-item"><i class="ft-check-square"></i>View Current Stock</a>
                            </div>
                        </div>
                    </div>
                   
                </section>
                <!--/ User Profile Cards -->

            </div>
        </div>
    </div>
    <!-- END: Content-->
</body>
</asp:Content>
