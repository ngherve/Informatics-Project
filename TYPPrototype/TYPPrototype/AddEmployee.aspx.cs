using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace TYPPrototype
{
    public partial class addEmployee : System.Web.UI.Page
    {
        UserService.UserServiceClient client;

        protected void Page_Load(object sender, EventArgs e)
        {
            client = new UserService.UserServiceClient();
        }

        protected void btnSaveEmpl_Click(object sender, EventArgs e)
        {
            
            UserService.User user = new UserService.User
            {
                Name = fname.Value + " " + lname.Value,
                Username = username.Value,
                Email = email.Value,
                Password = pass.Value,
                Tel_Number = telnum.Value,
                Address = address.Value,
                Gender = gender.Value,
                DOB = dob.Value
            };
            string result = client.RegisterUser(user);

            Response.Write("<script>alert('" + result + "')</script>");
        }
    }
}