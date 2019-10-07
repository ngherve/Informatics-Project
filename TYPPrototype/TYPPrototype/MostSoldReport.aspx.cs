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
    public partial class MostSoldReport : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            GetChartData();
            getData();
        }



        private void getData()
        {
            ProductServiceClient prodService;
            Invoice[] data;
            prodService = new ProductServiceClient();

            data = prodService.GetAllInvoices();

            string lowstock = "Suggestion: ";
            foreach (Product u in prodService.GetAllProducts())
            {
                foreach (var i in data)
                {

                    if (i.P_Code.Equals(u.P_Code))
                    {
                        bool isdone = true;
                        foreach (var j in data)
                        {
                            if (!i.Inv_Type.Equals("dispatch"))
                            {
                                isdone = false;
                            }
                        }
                        if (isdone) lowstock += u.P_Name.ToUpper();
                    }
                }
            }
            if (!lowstock.Equals("Suggestion: "))
                lowstock += " Sells the fastest (:- should get the next jobs !!!";
            suggestiontask.InnerHtml = lowstock;
        }

        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public static object[] GetChartData()
        {
            ProductServiceClient ProService;
            Invoice[] invoice;
            ProService = new ProductServiceClient();
            Product[] product = ProService.GetAllProducts();
            invoice = ProService.GetAllInvoices();
            List<Invoice> data = new List<Invoice>();
            data = invoice.ToList();

            var chartData = new object[invoice.Count() + 1];
            chartData[0] = new object[]
            {
                "P_Code: ",
                "Product Quantity",
                "Invoice Quantity"
            };
            int j = 0;
            foreach (var i in data)
            {
                j++;
                foreach (Product u in product)
                {
                    //task per user
                    int taskcount = 0;
                    foreach (Invoice t in invoice)
                    {
                        if (u.P_Code.Equals(t.P_Code))
                        {
                            taskcount++;
                        }
                    }

                    //tasks done per user
                    int donecount = 0;

                    foreach (Invoice t in invoice)
                    {
                        if (u.P_Quantity.Equals(t.Quantity) && t.Inv_Type.Equals("dispatch"))
                        {
                            donecount++;
                        }
                    }

                    foreach (Invoice t in invoice)
                    {
                        if (u.P_Code.Equals(i.P_Code))
                        {
                            chartData[j] = new object[] { u.P_Code + ": " + i.Inv_Type , taskcount, donecount };
                        }
                    }
                }
            }
            return chartData;
        }
    }
}