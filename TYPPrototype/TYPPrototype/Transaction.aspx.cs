using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class Transaction : System.Web.UI.Page
    {
        ProductServiceClient ProductService;
        protected void Page_Load(object sender, EventArgs e)
        {
            ProductService = new ProductServiceClient();
            Invoice[] invoices = ProductService.GetAllInvoices();

            string display = "";

            foreach (Invoice inv in invoices)
            {
                Product p = ProductService.GetProductbyID(inv.P_ID);
                display += "<tr>"
                        + "<td><input type='checkbox' class='input-chk'></td>"
                        + "<td>"
                        + "<p class='text'>" + inv.INV_Date + "</p>"
                        + "</td>"
                        + "<td><span class='badge badge-success'>" + p.P_Code+" "+ p.P_Name + "</span></td>"
                        + "<td><span class='badge badge-danger'>" + inv.Quantity + "</span></td>"
                        + "<td><span class='badge badge-primary'>" + inv.Total_Price + "</span></td>"
                        + "<td class='text-center'>"
                        + "<p class='text'>" + inv.Inv_Type + "</p>"
                        + "<td>"
                        + "<div class='dropdown'>"
                        + "<button id='btnSearchDrop2' type='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false' class='btn btn-info dropdown-toggle'><i class='la la-cog align-middle'></i></button>"
                        + "<div aria-labelledby='btnSearchDrop2' class='dropdown-menu mt-1 dropdown-menu-right'>"
                        + "<a href='#' class='dropdown-item'><i class='ft-upload'></i> Assign to</a>"
                        + "<div class='dropdown-divider'></div>"
                        + " <a href=DeleteTask.aspx?ID=" + inv.INV_ID + " class='dropdown-item'><i class='ft-trash'></i> Delete Task</a>"
                        + " </div>"
                        + " </div>"
                        + " </td>"
                        + "</tbody>"
                        ;
            }
            //tasklist.InnerHtml = display;
            tablebody.InnerHtml = display;
        }
    }
}