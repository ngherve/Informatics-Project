<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="Tasks.aspx.cs" Inherits="TYPPrototype.Tasks" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">

   
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
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
                                    <li class="breadcrumb-item"><a href="#">Tasks</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Task List
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
                <section class="row" id="tasklist" runat="server">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Task List</h4>
                                <a class="heading-elements-toggle"><i class="la la-ellipsis-h font-medium-3"></i></a>
                                <div class="heading-elements">
                                    <asp:LinkButton ID="btnNewTask" runat="server"  BorderStyle="Solid" ToolTip="Submit" class="btn btn-primary btn-sm" OnClick="btnNewTask_Click"><i class="ft-plus white"></i> New Task </asp:LinkButton>    
                                </div>
                            </div>
                            <div class="card-content">
                                <div class="card-body">
                                    <!-- Task List table -->
                                    <div class="table-responsive">
                                        <table id="tasktable"  class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle">
                                            <thead>
                                                <tr>
                                                    <th><input type="checkbox" class="input-chk-all"></th>
                                                    <th>Task</th>
                                                    <th>Start Date</th>
                                                    <th>Status</th>
                                                    <th>Owner</th>
                                                    <th>Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                               <section id ="tablebody" runat="server">

                                               </section>
                                       
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th><input type="checkbox" class="input-chk"></th>
                                                    <th>Task</th>
                                                    <th>Start Date</th>
                                                    <th>Progress</th>
                                                    <th>Owner</th>
                                                    <th>Actions</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <!--/ Task List table -->
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
     </div>
   
    
    <!-- ************************************************************************************************** -->
    <!-- Task -->

</asp:Content>