<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="damagesReport.aspx.cs" Inherits="TYPPrototype.damagesReport" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">

     <%-- Here We need to write some js code for load google chart with database data --%>
    <script src="Scripts/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
 
    <script>
        var chartData; // globar variable for hold chart data
        google.load("visualization", "1", { packages: ["corechart"] });
 
        // Here We will fill chartData
 
        $(document).ready(function () {
           
            $.ajax({
                url: "damagesReport.aspx/GetChartData",
                data: "",
                dataType: "json",
                type: "POST",
                contentType: "application/json; chartset=utf-8",
                success: function (data) {
                    chartData = data.d;
                },
                error: function () {
                    alert("Error loading data! Please try again.");
                }
            }).done(function () {
                // after complete loading data
                google.setOnLoadCallback(drawChart);
                drawChart();
            });
        });

        function drawChart() {
            var data = google.visualization.arrayToDataTable(chartData);
 
            var options = {
                title: "Stock Damages",
                pointSize: 5
            };
 
            var pieChart = new google.visualization.BarChart(document.getElementById('chart_div'));
            pieChart.draw(data, options);
        }
    </script>

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="app-content content">
        <div class="content-header row">
            <div class="content-header-light col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title">Reports</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Reports</a>
                                    </li>
                                    <li class="breadcrumb-item active">Damages Report
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="content-header-right col-md-3 col-12">
                        <div class="btn-group float-md-right" role="group" aria-label="Button group with nested dropdown">
                            <button class="btn btn-primary round dropdown-toggle dropdown-menu-right box-shadow-2 px-2" id="btnGroupDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="component-alerts.html">Alerts</a><a class="dropdown-item" href="material-component-cards.html"> Cards</a><a class="dropdown-item" href="component-progress.html"> Progress</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="register-with-bg-image.html">Register</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="content-wrapper">
            <div class="content-body">
                <!-- Bar charts section start -->
                <section id="chartjs-bar-charts">
                    <!-- Bar Chart -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Damages Report</h4>
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
                                   <div id="chart_div" style="width:950px;height:500px">
                                       <%-- Here Chart Will Load --%>
                                   </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- // Bar charts section end -->
            </div>
        </div>
    </div>
    <!-- END: Content-->
</asp:Content>
