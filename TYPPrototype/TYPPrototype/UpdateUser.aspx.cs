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

        string n;
        string un;
        string em ;
        string tn ;
        string add ;
        
        string pp ;

        User u;
        protected void Page_Load(object sender, EventArgs e)
        {
            if(Session["UserType"].ToString()!="admin")
            {
                uTyp.Visible = false;
            }
            string code = Request.QueryString["ID"];
            userClient = new UserServiceClient();
            int id = int.Parse(code);
            u = userClient.GetUserbyID(id);
             



        }
        
        protected void btnEditEmployee_Click(object sender, EventArgs e)
        {

            if(ename.Value.Equals(""))
            {
                n = u.Name;
            }else
            {
                n = ename.Value;

            }
            if (eusername.Value.Equals(""))
            {
                un = u.Username;
            }
            else
            {
                un = eusername.Value;
            }
            if (eemail.Value.Equals(""))
            {
                em = u.Email;
            }
            else
            {
                em = eemail.Value;
            }
            if (etelnumber.Value.Equals(""))
            {
                tn = u.Tel_Number;
            }
            else
            {
                tn = etelnumber.Value;
            }
            if (eaddress.Value.Equals(""))
            {
                add = u.Address;
            }
            else
            {
                add = eaddress.Value;
            }
            

                
             
             
             
             
             pp =u.pphoto;

            u.Name = n;
            u.Username = un;
            u.Email = em;
            u.Tel_Number = tn;
            u.Address = add;
            u.Gender = gnd.SelectedValue;
            u.pphoto = pp;

            if (Session["UserType"].ToString() != "admin")
            {
                string cVal = u.User_Type;
                u.User_Type = cVal;
            }
            else
            {
                u.User_Type = Utype.SelectedValue;
            }
            
            string resp = userClient.UpdateUser(u);

            
            Response.Redirect("ManageUsers.aspx");
        }

        protected void btnCancelEdEmp_Click(object sender, EventArgs e)
        {
            Response.Redirect("ManageUsers.aspx");
        }
    }
}