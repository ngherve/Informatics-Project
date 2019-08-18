<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="EditProducts.aspx.cs" Inherits="TYPPrototype.EditProducts" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Shops</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="dashboard.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item active">Shop
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
                                                            <select id="userinput3" name="Supplier" class="form-control">
                                                                <option value="none" selected="" disabled="">Supplier Name</option>
                                                                <option value="Hewlett">Hewlett</option>
                                                                <option value="Modelez">Modelez</option>
                                                            </select>

                                                         <!--   
                                                            <asp:DropDownList ID="sname" runat="server">
                                                                <asp:ListItem Text="Schneider Electric" Value="Schneider Electric"></asp:ListItem>
                                                                <asp:ListItem Text="Hewlett" Value="Hewlett"></asp:ListItem>
                                                                <asp:ListItem Text="Modelez" Value="Modelez"></asp:ListItem>
                                                                </asp:DropDownList>  -->
                                                        </div>
                                                    </div> 
                                                </div>

                                                <h4 class="form-section"><i class="ft-mail"></i> Product Additional Information</h4>

                                                <div class="form-group">
                                                    <label for="userinput5">Warehouse Name</label>
                                                    <select id="userinput5" name="Warehouse" class="form-control">
                                                                <option value="none" selected="" disabled="">Warehouse</option>
                                                                <option value="Warehouse 1">Warehouse 1</option>
                                                                <option value="Warehouse 2">Warehouse 2</option>
                                                                <option value="Warehouse 3">Warehouse 3</option>
                                                            </select>
                                                    
                                               <!-- <asp:DropDownList ID="WH" runat="server">
                                                                <asp:ListItem Text="Warehouse1" Value="Warehouse1"></asp:ListItem>
                                                                <asp:ListItem Text="Warehouse2" Value="Warehouse2"></asp:ListItem>
                                                                <asp:ListItem Text="Warehouse3" Value="Warehouse3"></asp:ListItem>
                                                                </asp:DropDownList>
                                                   -->
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
