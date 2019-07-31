<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="ProductDetails.aspx.cs" Inherits="TYPPrototype.ProductDetails" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">                           
                        <h3 class="content-header-title">Stock Management</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Products</a>
                                    </li>
                                    <li class="breadcrumb-item active">Product Details
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                            <button class="btn btn-primary round dropdown-toggle dropdown-menu-right box-shadow-2 px-2" id="btnGroupDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
                            <div class="dropdown-menu"><a class="dropdown-item" href="component-alerts.html"> Alerts</a><a class="dropdown-item" href="material-component-cards.html"> Cards</a><a class="dropdown-item" href="component-progress.html"> Progress</a>
                                <div class="dropdown-divider"></div><a class="dropdown-item" href="register.aspx"> Register</a>
                            </div>
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
                                    <h4 class="card-title" id="basic-layout-colored-form-control">Add Employee</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <ul class="list-inline mb-0">
                                            <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                            <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-content collapse show">
                                    <div class="card-body">                                      
                                        <form class="form">
                                            <div class="form-body">
                                                <h4 class="form-section"><i class="la la-eye"></i> Employee Information</h4>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput1">Fist Name</label>
                                                            <input type="text" runat="server" id="fname" class="form-control border-primary" placeholder="Name" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput2">Last Name</label>
                                                            <input type="text" runat="server" id="lname" class="form-control border-primary" placeholder="Company" name="company">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput3">Username</label>
                                                            <input type="text" runat="server" id="username" class="form-control border-primary" placeholder="Username" name="username">
                                                        </div>
                                                    </div> 
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput3">Password</label>
                                                            <input type="text" runat="server" id="pass" class="form-control border-primary" placeholder="Password" name="Password">
                                                        </div>
                                                    </div> 
                                                </div>

                                                <h4 class="form-section"><i class="ft-mail"></i> Contact and Additional Information</h4>

                                                <div class="form-group">
                                                    <label for="userinput5">Email</label>
                                                    <input class="form-control border-primary" runat="server" type="email" placeholder="email" id="email">
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput6">ID Number</label>
                                                    <input class="form-control border-primary" runat="server" type="text" placeholder="id number" id="idnum">
                                                </div>

                                                <div class="form-group">
                                                    <label>Contact Number</label>
                                                    <input class="form-control border-primary" runat="server" id="telnum" type="tel" placeholder="Telephone Number">
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput8">Gender</label>                 
                                                    <input id="gender" class="form-control border-primary" runat="server" name="gender" placeholder="gender" >
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput8">Address</label>
                                                    <input id="address" class="form-control border-primary" runat="server" name="Address" placeholder="Address" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="userinput8">Date Of Birth(DOB)</label>
                                                    <input id="dob" class="form-control border-primary" runat="server" type="date" name="dob">
                                                </div>

                                            </div>

                                            <div class="form-actions text-right">
                                                <button type="button" class="btn btn-warning mr-1">
                                                    <i class="ft-x"></i> Cancel
                                                </button>
                                                <button type="submit" class="btn btn-primary">
                                                    <i class="la la-check-square-o"></i> Save
                                                </button>
                                                <asp:Button ID="btnSaveEmpl" onclick="btnSaveEmpl_Click" runat="server" Text="Save" BorderStyle="Solid" ToolTip="Submit" class="btn btn-primary"/>  

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
