using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Script.Services;
using System.Web.Services;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class invoicereport : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            GetChartData();
        }

        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public static object[] GetChartData()
        {
            ProductServiceClient prodService;
            Invoice[] invoices;
            prodService = new ProductServiceClient();

            invoices = prodService.GetAllInvoices();
            List<Invoice> data = new List<Invoice>();
            data = invoices.ToList();

            var chartData = new object[invoices.Count() + 1];
            chartData[0] = new object[]
            {
                "Invoice Type",
                "Inv_Quantity",
                "Total Price"
            };
            int j = 0;
            foreach (var i in data)
            {
                j++;
                chartData[j] = new object[] { "Type: " + i.Inv_Type +"("+ i.P_Code+")", i.Quantity, i.Total_Price};
            }

            return chartData;
        }
    }
}
