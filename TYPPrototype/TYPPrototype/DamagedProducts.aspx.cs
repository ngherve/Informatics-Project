﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{

    public partial class DamagedProducts : System.Web.UI.Page
    {
        ProductServiceClient prodService;

        protected void Page_Load(object sender, EventArgs e)
        {
            prodService = new ProductServiceClient();
            Damaged[] Dproducts = prodService.GetDamagedProducts();
            List<Product> DamagedProds = new List<Product>();
            foreach (Damaged prod in Dproducts)
            {
                Product p;
                p = prodService.GetProductbyID(prod.P_ID);
                DamagedProds.Add(p);
            }
            string display = "";


            foreach (Damaged prod in Dproducts)
            {
                display += "<div class='col-xl-4 col-md-6 col-12'>";
                display += "<div class='card'>";
                display += "<div class='text-center'>";
                display += "<div class='card-body'>";
                display += "<img src ='http://10.254.17.96:80/script/profile_image/prod" + prod.P_Photo + ".jpeg' class='rounded-circle  height-150' alt='Card image'>";
                display += "</div>";
                display += "<div class='card-body'>";
                display += "<h4 class='card-title'>" + prod.DateDamaged + "</h4>";
                display += "<h6 class='text-center'>" + " Code: " + prod.P_ID + "</h6>";

                display += "<h6 class='text-center'>" + " Quantity: " + prod.Quantity + "</h6>";
                display += "<h6 class='text-center'>" + " Description: " + prod.Description + "</h6>";
                //display += "<h6 class='text-center'>" + " Warehouse: " + prod.W_Name + "</h6>";
                //display += "<h6 class='text-center'>" + " Supplier: " + prod.Supplier_Name + "</h6>";
                display += "</div>";
                display += "<div class='card-body'>";
                display += "<a href=EditProducts.aspx?ID=" + prod.P_ID + " class='btn btn-danger mr-1'><i class='la la-plus'></i> Edit</a>";
                display += "<a href=DeleteProduct.aspx?ID=" + prod.P_ID + " class='btn btn-primary mr-1'><i class='ft-user'></i> Remove</a>";
                display += "</div>";
                display += "</div>";
                display += "</div>";
                display += "</div>";
            }

            prodlist.InnerHtml = display;


        }

    }
}