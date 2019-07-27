﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class EditProducts : System.Web.UI.Page
    {
        ProductServiceClient prodClient;
        string prodcode;
        protected void Page_Load(object sender, EventArgs e)
        {
            string code = Request.QueryString["ID"];
            prodClient = new ProductServiceClient();
            int id = int.Parse(code);
            Product p = prodClient.GetProductbyID(id);
            prodcode = p.P_Code;
            pname.Value = p.P_Name;
            pprice.Value = Convert.ToString(p.P_Price);
            ptype.Value = p.P_Type;
            suppname.Value = p.Supplier_Name;
            wname.Value = p.W_Name;
            pquantity.Value = Convert.ToString(p.P_Quantity);
            pcode.Value = p.P_Code;
            //pimage.Value = p.P_Image;

        }

        protected void btnEditProduct_Click(object sender, EventArgs e)
        {
            Product prod = new Product();
            prod.P_Name = pname.Value;
            prod.P_Price = Convert.ToInt32(pprice.Value);
            prod.P_Type = ptype.Value;
            prod.Supplier_Name = suppname.Value;
            prod.W_Name = wname.Value;
            prod.P_Quantity = Convert.ToInt32(pquantity.Value);
            prod.P_Code = prodcode;
            prod.P_Image = pimage.Value;
            string resp = prodClient.UpdateProduct(prod);

            Response.Write("<script>alert('" + "Product " + resp + "')</script>");

        }

        protected void btnCancelEdPro_Click(object sender, EventArgs e)
        {
            Response.Redirect("Productlist.aspx");
        }
    }
}