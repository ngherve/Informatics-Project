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


            //foreach(Product prod in products)
            for (int i = products.Length - 1; i >= 0; i--)
            {
                display += "<div class='col-xl-4 col-md-6 col-12'>";
                display += "<div class='card'>";
                display += "<div class='text-center'>";
                display += "<div class='card-body'>";
                display += "<img src ='http://10.254.17.96:80/script/profile_image/prod" + products[i].P_Code + ".jpeg' class='rounded-circle  height-150' alt='Card image'>";
                display += "</div>";
                display += "<div class='card-body'>";
                display += "<h4 class='card-title'>" + products[i].P_Name + "</h4>";
                display += "<h6 class='text-center'>" + " Code: " + products[i].P_Code + "</h6>";
                display += "<h6 class='text-center'>" + " Price: R" + products[i].P_Price + "</h6>";
                display += "<h6 class='text-center'>" + " Quantity: " + products[i].P_Quantity + "</h6>";
                display += "<h6 class='text-center'>" + " Type: " + products[i].P_Type + "</h6>";
                display += "<h6 class='text-center'>" + " Warehouse: " + products[i].W_Name + "</h6>";
                display += "<h6 class='text-center'>" + " Supplier: " + products[i].Supplier_Name + "</h6>";
                display += "</div>";
                display += "<div class='card-body'>";
                display += "<a href=EditProducts.aspx?ID=" + products[i].P_ID + " class='btn btn-danger mr-1'><i class='la la-plus'></i> Edit</a>";
                display += "<a href=DeleteProduct.aspx?ID=" + products[i].P_ID + " class='btn btn-primary mr-1'><i class='ft-user'></i> Remove</a>";
                display += "</div>";
                display += "</div>";
                display += "</div>";
                display += "</div>";
            }
            
            prodlist.InnerHtml = display;


        }

    }
}