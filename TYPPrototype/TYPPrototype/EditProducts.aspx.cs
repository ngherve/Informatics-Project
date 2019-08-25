using System;
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
        Product p;
        Product prod;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["UserType"].ToString() != "admin")
            {
                if (Session["UserType"].ToString() != "stock")
                {
                    Response.Redirect("home.aspx"); ;
                }

            }
            string code = Request.QueryString["ID"];
            prodClient = new ProductServiceClient();
            int id = int.Parse(code);
            p = prodClient.GetProductbyID(id);

            prod = new Product();
            prod.P_Name = p.P_Name;
            prod.P_Price =p.P_Price;
            prod.P_Type = p.P_Type;
            prod.Supplier_Name = p.Supplier_Name;
            prod.W_Name = p.W_Name;
            prod.P_Quantity = p.P_Quantity;
            prod.P_Code = prodcode;
            prod.P_Image = p.P_Image;
            
            
            //pname.Value = p.P_Name;
           // pprice.Value = Convert.ToString(p.P_Price);
           // ptype.Value = p.P_Type;
            //suppname.Value = p.Supplier_Name;
            //wname.Value = p.W_Name;
           // pquantity.Value = Convert.ToString(p.P_Quantity);
           // pcode.Value = p.P_Code;
            //pimage.Value = p.P_Image;

        }

        protected void btnEditProduct_Click(object sender, EventArgs e)
        {
           

            if (pname.Value.Equals(""))
            {
                p.P_Name = prod.P_Name;
            }
            else
            {
                p.P_Name = pname.Value;

            }

            if (pprice.Value.Equals(""))
            {
                p.P_Price = prod.P_Price;
            }
            else
            {
                p.P_Price = Convert.ToInt32(pprice.Value);

            }

           
                p.P_Type = ptype.SelectedValue;
            

            
            if (pquantity.Value.Equals(""))
            {
                p.P_Quantity = prod.P_Quantity;
            }
            else
            {
                p.P_Quantity = Convert.ToInt32(pquantity.Value);

            }
            p.Supplier_Name = sname.SelectedValue;
            p.W_Name = WH.SelectedValue;
            p.P_Image = prod.P_Image;

            string resp = prodClient.UpdateProduct(p);
           // Response.Write("<script>alert('" + "Product " + resp + "')</script>");

            if (resp.Equals("Data Updated Successfully"))
            {
                Response.Redirect("Productlist.aspx");
            }
            

        }

        protected void btnCancelEdPro_Click(object sender, EventArgs e)
        {
            Response.Redirect("Productlist.aspx");
        }
    }
}