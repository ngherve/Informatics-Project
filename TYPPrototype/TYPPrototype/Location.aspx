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
                                        <img src="../../../app-assets/images/elements/Mechanical.png" alt="apple-watch" width="250px" class="img-fluid p-2">
                                      <!-- <asp:Button ID="btnMech" runat="server" Text="View" BorderStyle="Solid" ToolTip="Submit" class="btn btn-success btn-block btn-glow text-uppercase p-1" OnClick="btnMech_Click"/> -->
                                        <asp:Button ID="btnsec" runat="server" Text="View" BorderStyle="Solid" ToolTip="Submit" class="btn btn-success btn-block btn-glow text-uppercase p-1" OnClick="btnsec_Click"  />
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
                                      
                                        <img src="../../../app-assets/images/elements/tape.jpg" alt="apple-watch" width="250px" class="img-fluid p-2">
            

                                         <asp:Button ID="btnInd" runat="server" Text="View" BorderStyle="Solid" ToolTip="Submit" class="btn btn-success btn-block btn-glow text-uppercase p-1" OnClick="btnInd_Click"   />  

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
                                       
                                        <img src="../../../app-assets/images/elements/wires.jpg" alt="apple-watch" width="250px" class="img-fluid p-2">
                                        <asp:Button ID="btnElec" runat="server" Text="View" BorderStyle="Solid" ToolTip="Submit" class="btn btn-success btn-block btn-glow text-uppercase p-1" OnClick="btnElec_Click"   />
                                    </div>
                                </div>
                            </div>
                        </div>
                      
                <!-- User Profile Cards -->
                <section  runat="server" id="prodware" class="row mt-2">
                    <div class="col-12">
                        <h4 class="text-uppercase">Product Records</h4>
                    </div>

                </section>
                
                <!--/ User Profile Cards -->

            </div>            
            </div>
        </div>
    </div>

</asp:Content>
