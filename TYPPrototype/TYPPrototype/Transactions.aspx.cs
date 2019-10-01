using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class Transactions : System.Web.UI.Page
    {
        ProductServiceClient prodService;
        protected void Page_Load(object sender, EventArgs e)
        {
            prodService = new ProductServiceClient();
            Invoice[] invoices = prodService.GetAllInvoices();
            Product[] products = prodService.GetAllProducts();
            string display = "";
            Product pro = null;

            foreach (Invoice inv in invoices)
            {
                foreach(Product p in products)
                {
                    if (p.P_Code.Equals(inv.P_Code))
                    {
                        pro = p;
                    }
                }if (pro != null)
                {
                    display += "<tr>"
                           + "<td><input type='checkbox' class='input-chk'></td>"
                           + "<td>"
                           + "<p class='text'>" + inv.INV_Date + "</p>"
                           + "</td>"
                           + "<td><span class='badge badge-primary'>" + pro.P_Name + " " + inv.P_Code + "</span></td>"
                           + "<td><p class='text'>" + inv.Quantity + "</p></td>"
                           + "<td><span class='badge badge-danger'>" + inv.Total_Price + "</span></td>"
                           + "<td><span class='badge badge-primary'>" + inv.Inv_Type + "</span></td>"
                           + "</tbody>"
                           ;
                }
            }
            trans.InnerHtml = display;

        }
    }
}