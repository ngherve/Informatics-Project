using System;
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

            foreach (User user in products)
            {
                display += "<div class='col-xl-4 col-md-6 col-12'>"
                        + "<div class='card'>"
                        + "<div class='text-center'>"
                        + "<div class='card-body'>"
                        + "<img src ='http://10.254.17.96:80/script/profile_image/" + user.UserID + ".jpeg' class='rounded-circle  height-150' alt='Card image'>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<h4 class='card-title'>" + user.Name + " Username:" + user.Username + " " + user.UserID + "</h4>"
                        + "<h6 class='card-subtitle text-muted'>" + "Gender: " + user.Gender + " Tel_Number: " + user.Tel_Number + "</h6>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<h6 class='card-subtitle text-muted'>" + "Date of Birth: " + user.DOB + " User_type: " + user.User_Type + "</h6>"
                        + "</div>"
                        + "<div class='card-body'>"
                        + "<a href=UpdateUser.aspx?ID=" + user.UserID + " class='btn btn-danger mr-1'><i class='la la-plus'></i> Edit</a>"
                        + "<a href=DeleteUser.aspx?ID=" + user.UserID + " class='btn btn-primary mr-1'><i class='ft-user'></i> Remove</a>"
                        + "</div>"
                        + "</div>"
                        + "<div class='list-group list-group-flush'>"
                        + "<a href = '#' class='list-group-item'><i class='ft-mail'></i>Email: " + user.Email +"</a>"
                        + "<a href = '#' class='list-group-item'> <i class='ft-message-square'>Address: </i>" + user.Address + "</a>"
                        + "</div>"
                        + "</div>"
                        + "</div>";
            }
            userlist.InnerHtml = display;

        }
    }
}