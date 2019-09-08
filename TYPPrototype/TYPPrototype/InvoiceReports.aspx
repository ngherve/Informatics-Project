<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.Master" AutoEventWireup="true" CodeBehind="InvoiceReports.aspx.cs" Inherits="TYPPrototype.invoicereport" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
     <%-- Here We need to write some js code for load google chart with database data --%>
    <script src="Scripts/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
 
    <script>
        var chartData; // globar variable for hold chart data
        google.load("visualization", "1", { packages: ["corechart"] });
 
        // Here We will fill chartData
 
        $(document).ready(function ()
        {
           
            $.ajax({
                url: "InvoiceReports.aspx/GetChartData",
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

        function drawChart()
        {
            var data = google.visualization.arrayToDataTable(chartData);
 
            var options =
            {
                title: "Invoice Reports",
                pointSize: 5,                   
            };
 
            var lineChart = new google.visualization.PieChart(document.getElementById('chart_div'));
            lineChart.draw(data, options);
        }
    </script>
   
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="app-content content">
        
        <div class="content-header row">
            <div class="content-header-dark col-12">
                <div class="row">
                    <div class="content-header-left col-md-9 col-12 mb-2">
                        <h3 class="content-header-title white">Project Task</h3>
                        <div class="row breadcrumbs-top">
                            <div class="breadcrumb-wrapper col-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="home.aspx">Home</a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="#">Reports</a>
                                    </li>
                                    <li class="breadcrumb-item active">Invoice Report
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
         
        <div id="chart_div" style="width:1100px;height:500px">
            <%-- Here Chart Will Load --%>
        </div>
    </div>
    <!-- END: Content-->
</asp:Content>
