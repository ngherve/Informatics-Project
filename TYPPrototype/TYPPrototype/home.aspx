<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="home.aspx.cs" Inherits="TYPPrototype.home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-header row">
        </div>
            <div class="content-body">
                 <div id="carousel-example-caption" class="carousel slide" data-ride="carousel">
                         <ol class="carousel-indicators">
                             <li data-target="#carousel-example-caption" data-slide-to="0" class="active"></li>
                             <li data-target="#carousel-example-caption" data-slide-to="1"></li>
                             <li data-target="#carousel-example-caption" data-slide-to="2"></li>
                          </ol>
                           <div class="carousel-inner" role="listbox">
                                                <div class="carousel-item active">
                                                    <img src="../../../app-assets/images/carousel/16.jpg" class="img-fluid" alt="First slide">
                                                    <div class="carousel-caption">
                                                        <h2>Revolutionary Inventory Management</h2>
                                                        <h2> Change the way you Manage Stock</h2>

                                                        
                                                    </div>
                                                </div>
                                                <div class="carousel-item">
                                                    <img src="../../../app-assets/images/carousel/11.jpg" class="img-fluid" alt="Second slide">
                                                    <div class="carousel-caption">
                                                        <h2>Keep Track of Products</h2>
                                                        <h2>Real Time Location Tracking</h2>
                                                       
                                                    </div>
                                                </div>
                                                <div class="carousel-item">
                                                    <img src="../../../app-assets/images/carousel/28.jpg" class="img-fluid" alt="Third slide">
                                                    <div class="carousel-caption">
                                                        <h2>User Management</h2>
                                                        <h2>Track user Activity and Deploy Tasks</h2>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                <a class="carousel-control-prev" href="#carousel-example-caption" role="button" data-slide="prev">
                                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                      <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carousel-example-caption" role="button" data-slide="next">
                                       <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                       <span class="sr-only">Next</span>
                                       </a>
                         </div>
            </div>   
    </div>
    <!-- END: Content-->


</asp:Content>
