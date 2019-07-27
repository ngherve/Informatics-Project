using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class UpdateUser : System.Web.UI.Page
    {
        UserServiceClient userClient;
        string usercode;
        protected void Page_Load(object sender, EventArgs e)
        {
            string code = Request.QueryString["ID"];
            userClient = new UserServiceClient();
            int id = int.Parse(code);
            User u = userClient.GetUserbyID(id);
            usercode = Convert.ToString(u.UserID);
            ename.Value = u.Name;
            eusername.Value = u.Username;
            eemail.Value = u.Email;
            epassword.Value = u.Password;
            etelnumber.Value = u.Tel_Number;
            eaddress.Value = u.Address;
            egender.Value = u.Gender;
            edob.Value = u.DOB;
            eusertype.Value = u.User_Type;
            //pimage.Value = p.P_Image;

        }
        
        protected void btnEditEmployee_Click(object sender, EventArgs e)
        {
            User user = new User();
            user.Name = ename.Value;
            user.Username = eusername.Value;
            user.Email = eemail.Value;
            user.Password = epassword.Value;
            user.Tel_Number = etelnumber.Value;
            user.Address = eaddress.Value;
            user.Gender = egender.Value;
            user.DOB = edob.Value;
            string resp = userClient.UpdateUser(user);

            Response.Write("<script>alert('" + resp + "')</script>");
        }

        protected void btnCancelEdEmp_Click(object sender, EventArgs e)
        {
            Response.Redirect("ManageUsers.aspx");
        }
    }
}