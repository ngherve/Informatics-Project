using System;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class Productlist : System.Web.UI.Page
    {
        ProductServiceClient prodService;

        protected void Page_Load(object sender, EventArgs e)
        {
            prodService = new ProductServiceClient();
            Product[] products = prodService.GetAllProducts();

            string display = "";

            foreach(Product prod in products)
            {
                display += "<div class='col-xl-4 col-md-6 col-12'>"
                        + "<div class='card'>" 
                        + "<div class='text-center'>"
                        + "<div class='card-body'>"
                        + "<img src ='http://10.254.17.96:80/script/profile_image/prod"+ prod.P_Code +".jpeg' class='rounded-circle  height-150' alt='Card image'>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<h4 class='card-title'>"+ prod.P_Name + " R" + prod.P_Price + " " + prod.P_Code +"</h4>"
                        + "<h6 class='card-subtitle text-muted'>"+ "Quantity: "+ prod.P_Quantity +" Type: " + prod.P_Type +"</h6>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<h6 class='card-subtitle text-muted'>" + "Supplier: " + prod.Supplier_Name + " Warehouse: " + prod.W_Name + "</h6>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<a href=EditProducts.aspx?ID=" + prod.P_ID + " class='btn btn-danger mr-1'><i class='la la-plus'></i> Edit</a>"
                        + "<a href=DeleteProduct.aspx?ID=" + prod.P_ID +" class='btn btn-primary mr-1'><i class='ft-user'></i> Remove</a>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "</div>";
            }
            prodlist.InnerHtml = display;
        }

    }
}