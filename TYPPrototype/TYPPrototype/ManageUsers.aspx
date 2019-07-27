<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="ManageUsers.aspx.cs" Inherits="TYPPrototype.ManageUsers" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title">Employees</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="ViewEmployees.aspx">View Employee</a>
                                    </li>
                                    <li class="breadcrumb-item active">Employee Records
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
