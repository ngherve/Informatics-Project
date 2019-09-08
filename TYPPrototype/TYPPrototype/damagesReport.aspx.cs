using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Services;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class damagesReport : System.Web.UI.Page
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
            Damaged[] products;
            Product[] product;
            object[] retChartData = null; 
            prodService = new ProductServiceClient();

            products = prodService.GetDamagedProducts();
            List<Damaged> data = new List<Damaged>();
            data = products.ToList();
            int x = 0;
            product = prodService.GetAllProducts();
            foreach (Product p in product)
            {

                if (p.P_ID.Equals(products[x].P_ID))
                {

                    var chartData = new object[products.Count() + 1];
                    chartData[0] = new object[]{
                    "Date of Damage",
                    "Amount Damaged",
                    "Quantity in Stock"
                };
                    int j = 0;
                    foreach (var i in data)
                    {
                        j++;
                        chartData[j] = new object[] { p.P_Name + "(" + i.DateDamaged + ")", i.Quantity, p.P_Quantity };
                    }
                    retChartData = chartData;
                }
             
            }
            return retChartData;
        }
    }
}