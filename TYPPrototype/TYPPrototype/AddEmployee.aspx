<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="addEmployee.aspx.cs" Inherits="TYPPrototype.addEmployee" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">                           
                        <h3 class="content-header-title white" runat="server" id="AdminFunction">Admin</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Employee Management</a>
                                    </li>
                                    <li class="breadcrumb-item active">Add Employee
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
                                                            <label for="userinput1">First Name</label>
                                                            <input type="text" runat="server" id="name" class="form-control border-primary" placeholder="Name" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput2">User Type</label>
                                                            <asp:DropDownList ID="Utype" runat="server">
                                                                <asp:ListItem Text="Stock" Value="stock"></asp:ListItem>
                                                                <asp:ListItem Text="Admin" Value="admin"></asp:ListItem>
                                                                <asp:ListItem Text="Warehouse" Value="warehouse"></asp:ListItem>
                                                                </asp:DropDownList>
                                                            

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
                                                            <input type="password" runat="server" id="pass" class="form-control border-primary" placeholder="Password" name="Password">
                                                        </div>
                                                    </div> 
                                                </div>

                                                <h4 class="form-section"><i class="ft-mail"></i> Contact and Additional Information</h4>

                                                <div class="form-group">
                                                    <label for="userinput5">Email</label>
                                                    <input class="form-control border-primary" runat="server" type="email" placeholder="email" id="email">
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput6">Profile Image</label>
                                                    <input class="form-control border-primary" runat="server" type="file" placeholder="Image" id="pimage">
                                                    <script type="text/javascript">
                                                    function getFilePath(){
                                                        $('input[type=file]').change(function () {
                                                            console.log(this.files[0].mozFullPath);
                                                        });
                                                    }
                                                    </script>
                                                </div>

                                                <div class="form-group">
                                                    <label>Contact Number</label>
                                                    <input class="form-control border-primary" runat="server" id="telnum" type="tel" placeholder="Telephone Number">
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput8">Gender</label>                 
                                                    <asp:DropDownList ID="GenderList" runat="server">
                                                                <asp:ListItem Text="Male" Value="Male"></asp:ListItem>
                                                                <asp:ListItem Text="Female" Value="Female"></asp:ListItem>
                                                                <asp:ListItem Text="Other" Value="Other"></asp:ListItem>
                                                                </asp:DropDownList>
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
                                                <asp:Button ID="btnCancelEmp" runat="server" Text="Cancel" BorderStyle="Solid" ToolTip="Submit" class="btn btn-warning mr-1" OnClick="btnCancelEmp_Click"/>  

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
