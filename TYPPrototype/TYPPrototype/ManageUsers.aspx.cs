﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class ManageUsers : System.Web.UI.Page
    {
        UserServiceClient userService;
        protected void Page_Load(object sender, EventArgs e)
        {
            userService = new UserServiceClient();

            User[] products = userService.GetAllUsers();

            string display = "";

            //foreach (User user in products)
            for (int i = products.Length - 1; i >= 0; i--)
            {
                display += "<div class='col-xl-4 col-md-6 col-12'>"
                        + "<div class='card'>"
                        + "<div class='text-center'>"
                        + "<div class='card-body'>"
                        + "<img src ='http://10.254.17.96:80/script/profile_image/" + products[i].UserID + ".jpeg' class='rounded-circle  height-150' alt='Card image'>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<h4 class='card-title'>" + products[i].Name + "</h4>"
                        + "<h6 class='text-center'>" + "Username: " + products[i].Username + "</h6>"
                        + "<h6 class='text-center'>" + "Gender: " + products[i].Gender + "</h6>"
                        + "<h6 class='text-center'>" + " Contacts: " + products[i].Tel_Number + "</h6>"
                        + "<h6 class='text-center'>" + " Date of Birth: " + products[i].DOB + "</h6>"
                        + "<h6 class='text-center'>" + " User Type: " + products[i].User_Type + "</h6>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<a href=UpdateUser.aspx?ID=" + products[i].UserID + " class='btn btn-danger mr-1' onclick='return confirm('Are you sure?')'><i class='la la-plus'></i> Edit</a>"
                        + "<a href=DeleteUser.aspx?ID=" + products[i].UserID + " class='btn btn-primary mr-1'><i class='ft-user'></i> Remove</a>"
                        + "</div>"
                        + "</div>"
                        + "<div class='list-group list-group-flush'>"
                        + "<a href = '#' class='list-group-item'><i class='ft-mail'></i>Email: " + products[i].Email +"</a>"
                        + "<a href = '#' class='list-group-item'> <i class='ft-message-square'>Address: </i>" + products[i].Address + "</a>"
                        + "</div>"
                        + "</div>"
                        + "</div>";
            }
            userlist.InnerHtml = display;

        }
    }
}