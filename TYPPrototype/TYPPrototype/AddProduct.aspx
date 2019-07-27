<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="addProduct.aspx.cs" Inherits="TYPPrototype.addProduct" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">                           
                        <h3 class="content-header-title">Admin</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Add </a>Product</li>
                                    <li class="breadcrumb-item active">Add Product Form
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
                <!-- Basic form layout section start -->
                <section id="basic-form-layouts">
                    <div class="row match-height">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                </div>
                                <div class="card-content collapse show">
                                    <div class="card-body">                                      
                                        <form class="form">
                                            <div class="form-body">
                                                <h4 class="form-section">Product Information</h4>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            Product<label for="userinput1"> Name:</label>&nbsp;
                                                            <input type="text" runat="server" id="Pname" class="form-control border-primary" placeholder="Name" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            Product<label for="userinput2"> Type</label> :&nbsp;
                                                            <input type="text" runat="server" id="Ptype" class="form-control border-primary" placeholder="Company" name="company">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <input type="text" runat="server" id="Pprice" class="form-control border-primary" placeholder="2560" name="username">
                                                        </div>
                                                    </div> 
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <input type="text" runat="server" id="PQuant" class="form-control border-primary" placeholder="54" name="Password">
                                                            <br />
                                                            Product Code:&nbsp; :&nbsp;
                                                    <input class="form-control border-primary" runat="server" id="PCode" type="text" placeholder="A01">
                                                            <br />
                                                            Product Image:&nbsp; :&nbsp;
                                                    <input class="form-control border-primary" runat="server" id="Pimage" type="text" placeholder="http//image:">
                                                        </div>
                                                    </div> 
                                                </div>

                                                <h4 class="form-section">Supplier and Additional Information</h4>

                                                <div class="form-group">
                                                    <label for="userinput5">Supplier Name:</label>
                                                    <input class="form-control border-primary" runat="server" type="text" placeholder="Schnieder Electric" id="SName">
                                                </div>

                                                <div class="form-group">
                                                    Warehouse Name:
                                                    <input class="form-control border-primary" runat="server" type="text" placeholder="WearHouse 2" id="WName">
                                                </div>

                                                <div class="form-group">
                                                </div>

                                                <div class="form-group">
                                                    &nbsp;
                                                </div>
                                                <div class="form-group">
                                                    &nbsp;
                                                </div>

                                            </div>

                                            <div class="form-actions text-right">

                                                <asp:Button ID="btnCancelPro" runat="server" Text="Cancel" BorderStyle="Solid" ToolTip="Submit" class="btn btn-warning mr-1" OnClick="btnCancelPro_Click" />  

                                                <asp:Button ID="svePro" OnClick="Savebtn_Click" runat="server" Text="Save" BorderStyle="Solid" ToolTip="Submit" class="btn btn-primary"/>  

                                            </div>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                          
                </section>
                <!-- // Basic form layout section end -->
            </div>
        </div>
    </div>
    <!-- END: Content-->
</asp:Content>