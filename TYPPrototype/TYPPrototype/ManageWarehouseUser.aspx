<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="ManageWarehouseUser.aspx.cs" Inherits="TYPPrototype.ManageWarehouseUser" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">

          <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Admin</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="dashboard.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Employee Management</a>
                                    </li>
                                    <li class="breadcrumb-item active">Manage User
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                            <button class="btn btn-primary round dropdown-toggle dropdown-menu-right box-shadow-2 px-2" id="btnGroupDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Group By</button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="ManageStockUser.aspx">Stock Users</a>
                                <a class="dropdown-item" href="ManageWarehouseUser.aspx">Warehouse Users</a>  
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-wrapper">
            <div class="content-body"> 
                <!-- User Profile Cards -->
                <section class="row mt-2" runat="server" id="userlist">
                    <div class="col-12" >
                        <h4 class="text-uppercase">Employee Records</h4>
                    </div>
                                      
                </section>
                <!--/ User Profile Cards -->

            </div>
        </div>
    </div>
    <!-- END: Content-->
</asp:Content>
