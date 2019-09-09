<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="Transaction.aspx.cs" Inherits="TYPPrototype.Transaction" %>
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
                                    <li class="breadcrumb-item"><a href="#">Transactions</a>
                                    </li>
                                    <li class="breadcrumb-item active"> Transaction History
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
                <section class="row" id="transactionlist" runat="server">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Transaction History</h4>
                                <a class="heading-elements-toggle"><i class="la la-ellipsis-h font-medium-3"></i></a>
                                <div class="heading-elements">
                                       
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
                                                    <th>Date</th>
                                                    <th>Product</th>
                                                    <th>Quantity</th>
                                                    <th>Total Price(R)</th>
                                                    <th>Type</th>
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
                                                    <th>Date</th>
                                                    <th>Product</th>
                                                    <th>Quantity</th>
                                                    <th>Total Price(R)</th>
                                                    <th>Type</th>
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
   
</asp:Content>
