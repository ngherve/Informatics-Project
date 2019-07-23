using System;
using System.Collections.Generic;
using System.Data;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using MySql.Data.MySqlClient;

namespace WirelecWCFService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class UserService : IUserService
    {
        private  static readonly string mycon = "server =localhost; Uid=root; password = ; " +
            "persistsecurityinfo = True; database =Wirelecdatabase; SslMode = none; Convert Zero Datetime=True";

        private MySqlConnection connection = new MySqlConnection(mycon);

        public string RegisterUser(User user)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("INSERT INTO USER(Name, Username, Email, Password, Tel_Number, Address, Gender, DOB) VALUES(@a1, @a2, @a3, @a4, @a5, @a6, @a7, @a8)", connection);
                cmd.Parameters.AddWithValue("@a1", user.Name);
                cmd.Parameters.AddWithValue("@a2", user.Username);
                cmd.Parameters.AddWithValue("@a3", user.Email);
                cmd.Parameters.AddWithValue("@a4", user.Password);
                cmd.Parameters.AddWithValue("@a5", user.Tel_Number);
                cmd.Parameters.AddWithValue("@a6", user.Address);
                cmd.Parameters.AddWithValue("@a7", user.Gender);
                cmd.Parameters.AddWithValue("@a8", user.DOB);
                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
            finally
            {
                connection.Close();
            }
            return "Data Saved Successfully";
        }

        public List<User> GetAllUsers()
        {
            List<User> users = new List<User>();
  
            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM USER";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                User user = null;
                foreach (DataRow dr in dt.Rows)
                {
                    user = new User();
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    users.Add(user);
                }
            }

            return users;
        }

        public bool LoginUser(string username, string password)
        {
            bool SuccessLogin = false;
            try
            {
                connection.Open(); //openning the connection   
                MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
                cmd.CommandType = CommandType.Text; //setting the command type
                cmd.CommandText = "SELECT * FROM USER WHERE Username = '" + username + "' AND Password = '" + password + "'";
                cmd.ExecuteNonQuery();
                DataTable dt = new DataTable();
                MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
                adapter.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    foreach (DataRow dr in dt.Rows)
                    {
                        if (dr["Username"].Equals(username) && dr["Password"].Equals(password))
                        {
                            return true;
                        }
                    }
                }

            }
            catch (Exception ex)
            {
                string response = "<script>alert('" + ex.Message + "')</script>";
                SuccessLogin = false;
            }
            finally
            {
                connection.Close();
            }
            return SuccessLogin;
        }
        
        public string CreateProduct(Products product)//Please test this!!! & Delete Product 
        {
            try
            {
                Products ps = new Products(3,"Wire", 152, "ImageOfWire", 16, "Harry HarryMan", "Electrical", 2);
                connection.Open();
                
                string query="insert into product(PID,P_Name, P_Price,P_Image, P_Quantity,Supplier_Name, P_Type, W_ID) VALUES(@px1,@px2, @px3, @px4, @px5, @px6, @px7,@px8,@px9)";
                MySqlCommand cmd = new MySqlCommand(query, connection);
                cmd.Parameters.AddWithValue("@px1", ps.PID);
                cmd.Parameters.AddWithValue("@px2", ps.P_Name);
                cmd.Parameters.AddWithValue("@px3", ps.P_Price);
                cmd.Parameters.AddWithValue("@px4", ps.P_Image);
                cmd.Parameters.AddWithValue("@px5", ps.P_Quantity);
                cmd.Parameters.AddWithValue("@px6", ps.Supplier_Name);
                cmd.Parameters.AddWithValue("@px7", ps.P_Type);
                cmd.Parameters.AddWithValue("@px8", ps.W_ID);
                if (connection.State == System.Data.ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
            finally
            {
                connection.Close();
            }
            return "Data Saved Successfully";
        }
        public string DeleteProduct(int id)
        {
                try
                {
                    //MySqlConnection conn = new MySqlConnection(connection);
                    connection.Open();
                    Console.WriteLine("Connected");

                    string query = "delete from product where P_ID=@id";
                    MySqlCommand cmd = new MySqlCommand(query, connection);
                    cmd.Parameters.Add("@id", MySqlDbType.Int32);

                    Console.Write("Deleting data....");
                    cmd.Parameters[0].Value = id;

                    cmd.ExecuteNonQuery();
                    Console.WriteLine("Done");


                    connection.Close();
                    Console.WriteLine("Closed");
                }
                catch (MySqlException e)
                {
                    Console.WriteLine("Error: " + e.Message);
                }
            return "Deleted Product";
        }


    


    
        List<Products> IUserService.GetProducts()
        {
            List<Products> pros = new List<Products>();

            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM PRODUCT";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                Products pro = null;
                foreach (DataRow dr in dt.Rows)
                {
                    pro = new Products();
                    pro.P_Name = dr["P_Name"].ToString();
                    pro.P_Price = Convert.ToInt32(dr["P_Price"]);
                    pro.P_Image = dr["P_Image"].ToString();
                    pro.P_Quantity = Convert.ToInt32(dr["P_Quantity"]);
                    pro.Supplier_Name = dr["Supplier_Name"].ToString();
                    pro.P_Type = dr["P_Type"].ToString();
                    pro.W_ID = Convert.ToInt32(dr["W_ID"]);
                    pros.Add(pro);
                }
            }

            return pros;
        }

        public string EditProduct(Products pro)
        {
            try
            {
                
                connection.Open();
                

                string query = "update product set P_Name=@name,P_Price=@price where P_ID=@id";
                MySqlCommand cmd = new MySqlCommand(query, connection);
                cmd.Parameters.AddWithValue("@name","EdittedName");
                cmd.Parameters.AddWithValue("@price", 56984);
                cmd.Parameters.AddWithValue("@id", 1);

                cmd.ExecuteNonQuery();
                


                connection.Close();
                
            }
            catch (MySqlException e)
            {
                Console.WriteLine("Error: " + e.Message);
            }
            return "Product edited";
        }
    }
}
