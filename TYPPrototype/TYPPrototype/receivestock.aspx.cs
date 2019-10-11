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
    public partial class receivestock : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            GetChartData();
            getData();
        }
        private void getData()
        {
            ProductServiceClient prodService;
            Product[] products;
            prodService = new ProductServiceClient();

            products = prodService.GetAllProducts();
            List<Product> data = new List<Product>();
            data = products.ToList();
           
            string lowstock = "The following items are low in stock;</br> ";
            foreach (var i in data)
            {
                if (i.P_Quantity < 30)
                {
                    lowstock += i.P_Name + "(" + i.P_Code + ")</br>";
                }
            }
            lowstock += "Suggestion: Order new Stock!!!";
            suggestion.InnerHtml = lowstock;
        }

        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public static object[] GetChartData()
        {
            ProductServiceClient prodService;
            Product[] products;
            prodService = new ProductServiceClient();
            
            products = prodService.GetAllProducts();
            List<Product> data = new List<Product>();
            data = products.ToList();

            var chartData = new object[products.Count() + 1];
            chartData[0] = new object[]{
                    "Product Name",
                    "Quantity in stock",
                    "Ideal Quantity"
                };
            int j = 0;
            foreach (var i in data)
            {
                j++;
                chartData[j] = new object[] { i.P_Name, i.P_Quantity, 30 };
                
            }
            return chartData;
        }
    }
}