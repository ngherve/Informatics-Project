<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="UpdateUser.aspx.cs" Inherits="TYPPrototype.UpdateUser" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">                           
                        <h3 class="content-header-title">Employee</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Edit Employee</a>
                                    </li>
                                    <li class="breadcrumb-item active">Edit Employee Form
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                            <button class="btn btn-primary round dropdown-toggle dropdown-menu-right box-shadow-2 px-2" id="btnGroupDrop3" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
                            <div class="dropdown-menu"><a class="dropdown-item" href="component-alerts.html"> Alerts</a><a class="dropdown-item" href="material-component-cards.html"> Cards</a><a class="dropdown-item" href="component-progress.html"> Progress</a>
                                <div class="dropdown-divider"></div><a class="dropdown-item" href="register.aspx"> Edit</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-wrapper">
            <div class="content-body">
                <!-- Basic form layout section start -->
                <section id="basic-form-layouts2">
                    <div class="row match-height">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title" id="basic-layout-colored-form-control3">Edit Employee</h4>
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
                                                            <label for="userinput1">Employee Name</label>
                                                            <input type="text" runat="server" id="ename" class="form-control border-primary" placeholder="Name" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput2">Employee Username</label>
                                                            <input type="text" runat="server" id="eusername" class="form-control border-primary" placeholder="Username" name="username">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput3">Email</label>
                                                            <input type="email" runat="server" id="eemail" class="form-control border-primary" placeholder="Email" name="email">
                                                        </div>
                                                    </div> 
                                                </div>


                                                <h4 class="form-section"><i class="ft-mail"></i> Employee Additional Information</h4>

                                                <div class="form-group">
                                                    <label for="userinput5">Telephone Number</label>
                                                    <input class="form-control border-primary" runat="server" type="tel" placeholder="Warehouse name" id="etelnumber">
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput6">Address</label>
                                                    <input class="form-control border-primary" runat="server" type="text" placeholder="Code" id="eaddress">
                                                </div>

                                                <div class="form-group">
                                                    <label>Gender</label>
                                                    <input class="form-control border-primary" runat="server" id="egender" type="text" placeholder="Gender">
                                                </div>
                                                

                                                <div class="form-group" id="uTyp" runat="server">
                                                    <label>User Type</label>
                                                    
                                                    <asp:DropDownList ID="Utype" runat="server">
                                                                <asp:ListItem Text="Stock" Value="stock"></asp:ListItem>
                                                                <asp:ListItem Text="Admin" Value="admin"></asp:ListItem>
                                                                <asp:ListItem Text="Warehouse" Value="warehouse"></asp:ListItem>
                                                                </asp:DropDownList>
                                                </div>

                                             

                                            </div>

                                            <div class="form-actions text-right">
                                                <asp:Button ID="btnCancelEdEmp" runat="server" Text="Cancel" BorderStyle="Solid" ToolTip="Submit" class="btn btn-warning mr-1" OnClick="btnCancelEdEmp_Click" />  

                                                <asp:Button ID="btnEditEmployee" runat="server" Text="Submit" BorderStyle="Solid" ToolTip="Submit" class="btn btn-primary" OnClick="btnEditEmployee_Click" />  

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
