<%@ Page Title="" Language="C#"  AutoEventWireup="true" CodeBehind="home.aspx.cs" Inherits="TYPPrototype.home" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Wilec</title>
    <link rel="apple-touch-icon" href="app-assets/images/ico/apple-icon-120.png" />
    <link rel="shortcut icon" type="image/x-icon" href="app-assets/images/ico/favicon.ico" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i%7CQuicksand:300,400,500,700" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />

    <!-- ************************************************************************************************** -->
    <!-- Task CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/material-vendors.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/extensions/rowReorder.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/extensions/responsive.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/ui/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/selects/select2.min.css">

    <!-- Task CSS -->
    <!-- ************************************************************************************************** -->

    <!-- ************************************************************************************************** -->
    <!-- Dashboard CSS -->
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/material-vendors.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/weather-icons/climacons.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/meteocons/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/morris.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/chartist.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/chartist-plugin-tooltip.css">

    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/material-vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/simple-line-icons/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-gradient.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/dashboard-ecommerce.css">
    <!-- Dashboard CSS -->
    <!-- ************************************************************************************************** -->

    <!-- ************************************************************************************************** -->
    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/material-vendors.min.css" />
    <!-- END: Vendor CSS-->

    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/material.css" />
    <link rel="stylesheet" type="text/css" href="app-assets/css/components.css" />
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.css" />
    <link rel="stylesheet" type="text/css" href="app-assets/css/material-extended.css" />
    <link rel="stylesheet" type="text/css" href="app-assets/css/material-colors.css" />
    <!-- END: Theme CSS-->

    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/material-vertical-menu.css" />
    <link rel="stylesheet" type="text/css" href="../../../app-assets/css/core/colors/material-palette-gradient.css">
    <!-- END: Page CSS-->

    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
    <!-- END: Custom CSS-->
    <!-- ************************************************************************************************** -->
</head>
<body class="vertical-layout vertical-menu material-vertical-layout material-layout 2-columns   fixed-navbar" data-open="click" data-menu="vertical-menu" data-col="2-columns">
    <%--<meta http-equiv="refresh" content="5" >--%>

    <nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light bg-blue bg-darken-3 navbar-shadow">
        <div class="navbar-wrapper">
            <div class="navbar-header">
                <ul class="nav navbar-nav flex-row">
                    <li class="nav-item mobile-menu d-md-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu font-large-1"></i></a></li>
                    <li class="nav-item"><a class="navbar-brand" href="home.aspx">
                        <img class="brand-logo" alt="Wirelec" src="app-assets/images/logo/logo.jpg" />
                        <h3 class="brand-text">Inventory Control</h3>
                    </a></li>
                    <li class="nav-item d-md-none"><a class="nav-link open-navbar-container" data-toggle="collapse" data-target="#navbar-mobile"><i class="material-icons mt-1">more_vert</i></a></li>
                </ul>
            </div>
            <div class="navbar-container content">

                <div class="collapse navbar-collapse" id="navbar-mobile">
                    <ul class="nav navbar-nav mr-auto float-left">
                        <li class="nav-item d-none d-md-block"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu"></i></a></li>
                        <li class="nav-item d-none d-lg-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon ft-maximize"></i></a></li>
                        <li class="dropdown nav-item mega-dropdown d-none d-lg-block"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown">Search</a>

                        </li>

                    </ul>
                    <ul class="nav navbar-nav float-right">

                        <li class="dropdown dropdown-notification nav-item" id="notlist" runat="server">
                            <a class="nav-link nav-link-label" href="#" data-toggle="dropdown"><i class="material-icons">notifications_none</i><span class="badge badge-pill badge-danger badge-up badge-glow">0</span></a>
                            <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
                                <li class="dropdown-menu-header">
                                    <h6 class="dropdown-header m-0"><span class="grey darken-2">Notifications</span></h6>
                                    <span class="notification-tag badge badge-danger float-right m-0">0 New</span>
                                </li>

                                <li class="dropdown-menu-footer"><a class="dropdown-item text-muted text-center" href="javascript:void(0)">Read all notifications</a></li>
                            </ul>
                        </li>
                        <li class="dropdown dropdown-notification nav-item">
                            <a class="nav-link nav-link-label" href="NotifyUser.aspx"><i class="ficon ft-mail"></i></a>
                        </li>
                        <li class="dropdown dropdown-user nav-item">
                            <a class="dropdown-toggle nav-link dropdown-user-link" href="LoginUser.aspx">
                                <span class="mr-1 user-name text-bold-700" id="EmployeeName" runat="server">LOGIN</span>
                                <span class="avatar avatar-online" id="empImage" runat="server">
                                    <img src="app-assets/images/portrait/small/avatar-s-19.png" alt="avatar"><i></i></span></a>
                            <div class="dropdown-menu dropdown-menu-right" id="menuEdit" runat="server">
                                <a class="dropdown-item" href="#"><i class="ft-user"></i>Edit Profile</a>
                                <a class="dropdown-item" href="user-cards.html"><i class="ft-check-square"></i>Tasks</a>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout.aspx"><i class="ft-power"></i>Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>


        </div>
    </nav>

    <!-- BEGIN: Main Menu-->

    <div class="main-menu material-menu menu-fixed menu-dark   menu-accordion menu-shadow " data-scroll-to-active="true">
        <div class="user-profile">
        </div>
        <div class="main-menu-content">
            <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
                <li class=" nav-item"><a href="home.aspx"><i class="material-icons">list_alt</i><span class="menu-title">Dashboard</span></a>
                </li>


                <li class="nav-item1" id="Prods" runat="server"><a href="#"><i class="material-icons">content_paste</i><span class="menu-title">Stock Management</span></a>
                    <ul class="menu-content" id="ProdM" runat="server">
                        <li><a class="menu-item" href="products.aspx"><i class="material-icons"></i><span>Products</span></a>
                            <ul class="menu-content">
                                <li><a class="menu-item" href="Productlist.aspx"><i class="material-icons"></i><span>Product Inventory</span></a>
                                </li>
                                <li><a class="menu-item" href="addProduct.aspx"><i class="material-icons"></i><span>Add Product</span></a>
                                </li>
                                <li><a class="menu-item" href="Location.aspx"><i class="material-icons"></i><span>Location</span></a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>


                <li class="nav-item" id="ware" runat="server"><a href="#"><i class="material-icons">content_paste</i><span class="menu-title">Warehouse</span></a>
                    <ul class="menu-content" id="WareM" runat="server">
                        <li><a class="menu-item" href="Tasks.aspx"><i class="material-icons"></i><span>Tasks</span></a>
                        </li>
                        <li><a class="menu-item" href="TaskSummary.aspx"><i class="material-icons"></i><span>Task Summary</span></a>
                        </li>
                        <li><a class="menu-item" href="ToDo.aspx"><i class="material-icons"></i><span>ToDo List</span></a>
                        </li>
                    </ul>
                </li>


                <li class="nav-item" id="AdminFunc2" runat="server"><a href="#"><i class="material-icons">edit</i><span class="menu-title"> Admin </span></a>
                    <ul class="menu-content" id="AdminM" runat="server">
                        <li><a class="menu-item" href="#"><i class="material-icons"></i><span>Employee Management</span></a>
                            <ul class="menu-content">
                                <li><a class="menu-item" href="addEmployee.aspx"><i class="material-icons"></i><span>Add Employee</span></a>
                                </li>

                                <li><a class="menu-item" href="ManageUsers.aspx"><i class="material-icons"></i><span>Manage Employee</span></a>
                                </li>
                            </ul>

                            <li><a class="menu-item" href="#"><i class="material-icons"></i><span>Supplier Management</span></a>
                                <ul class="menu-content">
                                    <li><a class="menu-item" href="contactSupplier.aspx"><i class="material-icons"></i><span>Contact Supplier</span></a>

                                    </li>
                                </ul>
                            </li>
                    </ul>
                </li>

                <li class=" nav-item" id="AdminFunc1" runat="server"><a href="#"><i class="material-icons">show_chart</i><span class="menu-title"> Reports </span></a>
                    <ul class="menu-content" id="AdminFunc1M" runat="server">

                        <li><a class="menu-item" href="ProductsReport.aspx"><i class="material-icons"></i><span>Products Report</span></a>
                        </li>
                        <li><a class="menu-item" href="invoicereport.aspx"><i class="material-icons"></i><span>Invoices</span></a>
                        </li>

                    </ul>
                </li>
            </ul>
        </div>

    </div>

    <!-- END: Main Menu-->
    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>


    <form id="form1" runat="server">
        <div>
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
                                    <h2>Change the way you Manage Stock</h2>


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

            <!-- ************************************************************************************************** -->
            <!-- Dashboard CSS -->
            <script src="app-assets/vendors/js/material-vendors.min.js"></script>
            <!-- BEGIN Vendor JS-->

            <!-- BEGIN: Page Vendor JS-->
            <script src="app-assets/vendors/js/charts/chartist.min.js"></script>
            <script src="app-assets/vendors/js/charts/chartist-plugin-tooltip.min.js"></script>
            <script src="app-assets/vendors/js/charts/raphael-min.js"></script>
            <script src="app-assets/vendors/js/charts/morris.min.js"></script>
            <script src="app-assets/vendors/js/timeline/horizontal-timeline.js"></script>
            <!-- END: Page Vendor JS-->

            <!-- BEGIN: Theme JS-->
            <script src="app-assets/js/core/app-menu.js"></script>
            <script src="app-assets/js/core/app.js"></script>
            <!-- END: Theme JS-->

            <!-- BEGIN: Page JS-->
            <script src="app-assets/js/scripts/pages/material-app.js"></script>
            <script src="app-assets/js/scripts/pages/dashboard-ecommerce.js"></script>

            <!-- Dashboard CSS -->
            <!-- ************************************************************************************************** -->

        </div>
    </form>



    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>
    <footer class="footer footer-static footer-light navbar-border navbar-shadow">
        <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2"><span class="float-md-left d-block d-md-inline-block">Copyright &copy; 2019 Inventory Control, Inc. All Rights Reserved</span><span class="float-md-right d-none d-lg-block">Wilec <i class="ft-heart pink"></i><span id="scroll-top"></span></span></p>
    </footer>

</body>
</html>
