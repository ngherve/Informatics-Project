<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="AddTask.aspx.cs" Inherits="TYPPrototype.AddTask" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

<!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">                           
                        <h3 class="content-header-title white">Warehouse Management</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="dashboard.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Tasks</a></li>
                                    <li class="breadcrumb-item active">Add Task
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
                                    <h4 class="card-title" id="basic-layout-colored-form-control">New Task</h4>
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
                                                <h4 class="form-section"><i class="la la-eye"></i> Add New Task</h4>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput1">Task Type</label>
                                                            <asp:DropDownList class="form-control border-primary" runat="server" ID="ttype">
                                                                 <asp:ListItem Text="Incoming" Value="incoming"></asp:ListItem>
                                                                <asp:ListItem Text="Dispatch" Value="dispatch"></asp:ListItem>
                                                                <asp:ListItem Text="Allocation" Value="allocation"></asp:ListItem>
                                                            </asp:DropDownList>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput2">Task Priority</label>
                                                            <asp:DropDownList class="form-control border-primary" runat="server" ID="prty">
                                                                <asp:ListItem Text="High" Value="High"></asp:ListItem>
                                                                <asp:ListItem Text="Medium" Value="Medium"></asp:ListItem>
                                                                <asp:ListItem Text="Low" Value="Low"></asp:ListItem> 
                                                            </asp:DropDownList>
                                                        </div>
                                                    </div>
                                                </div> 
                                                
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput3">Task Owner</label>
                                                            <asp:DropDownList class="form-control border-primary" runat="server" ID="Towner" AutoPostBack="True" OnSelectedIndexChanged="Towner_SelectedIndexChanged">
                                                                 
                                                            </asp:DropDownList>
                                                        </div>
                                                    </div>
                                                </div>  
                                                 <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput4">Product List</label>
                                                            <asp:DropDownList class="form-control border-primary" runat="server" ID="ProList" AutoPostBack="True" OnSelectedIndexChanged="Towner_SelectedIndexChanged">
                                                                 
                                                            </asp:DropDownList>
                                                        </div>
                                                    </div>
                                                </div> 
                                            </div>

                                              <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="userinput2">Quantity</label>
                                                            <input id="Quantity" runat="server" type="number" />
                                                        </div>
                                                    </div>
                                                </div> 


                                            


                                            <div class="form-actions text-right">
                                                <asp:Button ID="btnCancelTask" runat="server" Text="Cancel" BorderStyle="Solid" ToolTip="Submit" class="btn btn-warning mr-1" OnClick="btnCancelTask_Click" />  
                                                
                                                
                                         <asp:Button ID="btnAddTask" runat="server" Text="Add Task" BorderStyle="Solid" ToolTip="Submit" class="btn btn-primary" OnClick="btnAddTask_Click"  />  
                                            <div class="col-sm-6 col-12 text-center text-sm-right" id="error" runat="server"></div>
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
</asp:Content>