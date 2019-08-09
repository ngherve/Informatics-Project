<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="EditProducts.aspx.cs" Inherits="TYPPrototype.EditProducts" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">

        <!-- BEGIN: Content--
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">                           
                        <h3 class="content-header-title">Product</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Edit Product</a>
                                    </li>
                                    <li class="breadcrumb-item active">Edit Product Form
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                            <button class="btn btn-primary round dropdown-toggle dropdown-menu-right box-shadow-2 px-2" id="btnGroupDrop2" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
                            <div class="dropdown-menu"><a class="dropdown-item" href="component-alerts.html"> Alerts</a><a class="dropdown-item" href="material-component-cards.html"> Cards</a><a class="dropdown-item" href="component-progress.html"> Progress</a>
                                <div class="dropdown-divider"></div><a class="dropdown-item" href="register.aspx"> Edit</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- BEGIN: Content-->

        <div class="content-header row">
            <div class="content-header-dark bg-img col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Shops</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Home</a>
                                    </li>
                                    <li class="breadcrumb-item active">Shop
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                            <button class="btn btn-primary round dropdown-toggle dropdown-menu-right box-shadow-2 px-2" id="btnGroupDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
                            <div class="dropdown-menu"><a class="dropdown-item" href="component-alerts.html"> Alerts</a><a class="dropdown-item" href="material-component-cards.html"> Cards</a><a class="dropdown-item" href="component-progress.html"> Progress</a>
                                <div class="dropdown-divider"></div><a class="dropdown-item" href="register-with-bg-image.html"> Register</a>
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
                                    <h4 class="card-title" id="basic-layout-colored-form-control2">Edit Product</h4>
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
                                                <h4 class="form-section"><i class="la la-eye"></i> Product Information</h4>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput1">Item Name</label>
                                                            <input type="text" runat="server" id="pname" class="form-control border-primary" placeholder="Name" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput2">Price</label>
                                                            <input type="number" runat="server" id="pprice" class="form-control border-primary" placeholder="Price" name="company">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput3">Quantity</label>
                                                            <input type="number" runat="server" id="pquantity" class="form-control border-primary" placeholder="Username" name="username">
                                                        </div>
                                                    </div> 
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput3">Supplier Name</label>
                                                            
                                                            <asp:DropDownList ID="sname" runat="server">
                                                                <asp:ListItem Text="Schneider Electric" Value="Schneider Electric"></asp:ListItem>
                                                                <asp:ListItem Text="Hewlett" Value="Hewlett"></asp:ListItem>
                                                                <asp:ListItem Text="Modelez" Value="Modelez"></asp:ListItem>
                                                                </asp:DropDownList>
                                                        </div>
                                                    </div> 
                                                </div>

                                                <h4 class="form-section"><i class="ft-mail"></i> Product Additional Information</h4>

                                                <div class="form-group">
                                                    <label for="userinput5">Warehouse Name</label>
                                                    
                                                <asp:DropDownList ID="WH" runat="server">
                                                                <asp:ListItem Text="Warehouse1" Value="Warehouse1"></asp:ListItem>
                                                                <asp:ListItem Text="Warehouse2" Value="Warehouse2"></asp:ListItem>
                                                                <asp:ListItem Text="Warehouse3" Value="Warehouse3"></asp:ListItem>
                                                                </asp:DropDownList>
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput6">Product Code</label>
                                                    <input class="form-control border-primary" runat="server" type="text" placeholder="Code" id="pcode">
                                                </div>

                                                <div class="form-group">
                                                    <label>Product Type</label>
                                                    <input class="form-control border-primary" runat="server" id="ptype" type="text" placeholder="Product Type">
                                                </div>

                                                <div class="form-group">
                                                    <label for="userinput8">Product Image</label>                 
                                                    <input type="file" id="pimage" class="form-control border-primary" runat="server" name="image" placeholder="Product Image" >
                                                    <script type="text/javascript">
                                                    function getFilePath(){
                                                        $('input[type=file]').change(function () {
                                                            console.log(this.files[0].mozFullPath);
                                                        });
                                                    }
                                                    </script>  
                                                </div>

                                            </div>

                                            <div class="form-actions text-right">
                                                <asp:Button ID="btnCancelEdPro" runat="server" Text="Cancel" BorderStyle="Solid" ToolTip="Submit" class="btn btn-warning mr-1" OnClick="btnCancelEdPro_Click"/>  

                                                <asp:Button ID="btnEditProduct" runat="server" Text="Submit" BorderStyle="Solid" ToolTip="Submit" class="btn btn-primary" OnClick="btnEditProduct_Click"/>  

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
