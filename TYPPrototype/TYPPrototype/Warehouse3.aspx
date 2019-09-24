<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="Warehouse3.aspx.cs" Inherits="TYPPrototype.Warehouse3" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
     <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Products</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Location.aspx">Location</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Warehouses</a>
                                    </li>
                                    <li class="breadcrumb-item active">Electrical products
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
                <!-- User Profile Cards -->
                <section  runat="server" id="elec" class="row mt-2">
                    <div class="col-12">
                        <h4 class="text-uppercase">Product Records</h4>
                    </div>

                </section>
                
                <!--/ User Profile Cards -->

            </div>
        </div>
    </div>
    <!-- END: Content-->
</asp:Content>
