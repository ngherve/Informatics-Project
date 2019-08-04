using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class addEmployee : System.Web.UI.Page
    {
        UserServiceClient client;

        protected void Page_Load(object sender, EventArgs e)
        {
            if(Session["UserType"].ToString() != "admin")
            {
                Response.Redirect("home.aspx");
            }

                 
            client = new UserServiceClient();
        }

        protected void btnSaveEmpl_Click(object sender, EventArgs e)
        {

            User user = new User
            {
                Name = name.Value,
                Username = username.Value,
                Email = email.Value,
                Password = pass.Value,
                Tel_Number = telnum.Value,
                Address = address.Value,
                Gender = gender.Value,
                DOB = dob.Value,
                User_Type = usertype.Value,
                //pphoto = pimage.value
            };
            string result = client.RegisterUser(user);

            Response.Write("<script>alert('" + result + "')</script>");
        }

        protected void btnCancelEmp_Click(object sender, EventArgs e)
        {
            Response.Redirect("home.aspx");
        }
    }
}