using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WirelecWCFService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "ProductService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select ProductService.svc or ProductService.svc.cs at the Solution Explorer and start debugging.
    public class ProductService : IProductService
    {
        private static readonly string mycon = "server =localhost; Uid=root; password = ; " +
          "persistsecurityinfo = True; database =Wirelecdatabase; SslMode = none; Convert Zero Datetime=True";
        private MySqlConnection connection = new MySqlConnection(mycon);

        public string AddProduct(Product product)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("INSERT INTO PRODUCT( P_Name, P_Price, P_Image, P_Quantity, Supplier_Name, P_Type, W_Name, P_Code, bin_location) VALUES(@a1, @a2, @a3, @a4, @a5, @a6, @a7, @a8, @a9)", connection);
                cmd.Parameters.AddWithValue("@a1", product.P_Name);
                cmd.Parameters.AddWithValue("@a2", product.P_Price);
                cmd.Parameters.AddWithValue("@a3", product.P_Image);
                cmd.Parameters.AddWithValue("@a4", product.P_Quantity);
                cmd.Parameters.AddWithValue("@a5", product.Supplier_Name);
                cmd.Parameters.AddWithValue("@a6", product.P_Type);
                cmd.Parameters.AddWithValue("@a7", product.W_Name);
                cmd.Parameters.AddWithValue("@a8", product.P_Code);
                cmd.Parameters.AddWithValue("@a9", product.bin_location);

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
            return "Product Added Successfully";
        }

        public string DeleteProduct(int id)
        {
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "DELETE FROM PRODUCT WHERE P_ID = '" + id + "'";
            cmd.ExecuteNonQuery();

            return "Product Successfully Deleted";
        }

        public List<Product> GetAllProducts()
        {
            List<Product> products = new List<Product>();

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
                Product pro = null;
                foreach (DataRow dr in dt.Rows)
                {
                    pro = new Product();
                    pro.P_ID = Convert.ToInt32(dr["P_ID"].ToString());
                    pro.P_Name = dr["P_Name"].ToString();
                    pro.P_Price = Convert.ToInt32(dr["P_Price"].ToString());
                    pro.P_Image = dr["P_Image"].ToString();
                    pro.P_Quantity = Convert.ToInt32(dr["P_Quantity"].ToString());
                    pro.Supplier_Name = dr["Supplier_Name"].ToString();
                    pro.P_Type = dr["P_Type"].ToString();
                    pro.W_Name = dr["W_Name"].ToString();
                    pro.P_Code = dr["P_Code"].ToString();
                    pro.bin_location = dr["bin_location"].ToString();
                    products.Add(pro);
                }
            }

            return products;
        }

        public List<Invoice> GetInvoices()
        {
            List<Invoice> invoices = new List<Invoice>();

            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM INVOICE";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                Invoice pro = null;
                foreach (DataRow dr in dt.Rows)
                {
                    pro = new Invoice();
                    pro.INV_ID = Convert.ToInt32(dr["INV_ID"].ToString());
                    pro.P_Code = dr["P_Code"].ToString();
                    pro.Quantity = Convert.ToInt32(dr["Quantity"].ToString());
                    pro.Total_Price = Convert.ToInt32(dr["Total_Price"].ToString());
                    pro.C_ID = Convert.ToInt32(dr["C_ID"].ToString());
                    pro.INV_Date = dr["INV_Date"].ToString();
                    pro.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    pro.Inv_Type = dr["Inv_Type"].ToString();
                    invoices.Add(pro);
                }
            }

            return invoices;
        }

        public Product GetProductbyID(int id)
        {
            Product pro = null;
            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM PRODUCT WHERE product.P_ID = '" + id + "'";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {

                foreach (DataRow dr in dt.Rows)
                {
                    pro = new Product();
                    pro.P_ID = Convert.ToInt32(dr["P_ID"].ToString());
                    pro.P_Name = dr["P_Name"].ToString();
                    pro.P_Price = Convert.ToInt32(dr["P_Price"]);
                    pro.P_Image = dr["P_Image"].ToString();
                    pro.P_Quantity = Convert.ToInt32(dr["P_Quantity"].ToString());
                    pro.Supplier_Name = dr["Supplier_Name"].ToString();
                    pro.P_Type = dr["P_Type"].ToString();
                    pro.W_Name = dr["W_Name"].ToString();
                    pro.P_Code = dr["P_Code"].ToString();
                    pro.bin_location = dr["bin_location"].ToString();
                }
            }

            return pro;
        }

        public Product SearchProduct(string name)
        {
            Product pro = null;
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM PRODUCT WHERE product.P_Name LIKE CONCAT( '" + name + "')";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {

                foreach (DataRow dr in dt.Rows)
                {
                    pro = new Product();
                    pro.P_ID = Convert.ToInt32(dr["P_ID"].ToString());
                    pro.P_Name = dr["P_Name"].ToString();
                    pro.P_Price = Convert.ToInt32(dr["P_Price"].ToString());
                    pro.P_Image = dr["P_Image"].ToString();
                    pro.P_Quantity = Convert.ToInt32(dr["P_Quantity"].ToString());
                    pro.Supplier_Name = dr["Supplier_Name"].ToString();
                    pro.P_Type = dr["P_Type"].ToString();
                    pro.W_Name = dr["W_Name"].ToString();
                    pro.P_Code = dr["P_Code"].ToString();
                    pro.bin_location = dr["bin_location"].ToString();
                }
            }

            return pro;
        }

        public string UpdateProduct(Product product)
        {
            try
            {
                connection.Open();//openning the connection
                MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
                cmd.CommandType = CommandType.Text; //setting the command type
                cmd.CommandText = "UPDATE PRODUCT SET P_Name = '" + product.P_Name +
                    "',P_Price= '" + product.P_Price + "', P_Image ='" + product.P_Image + "',P_Quantity ='"+ 
                    product.P_Quantity + "',Supplier_Name ='" + product.Supplier_Name + "', P_Type='" + 
                    product.P_Type + "',W_Name ='" + product.W_Name + "',P_Code ='" + product.P_Code
                    + "',bin_location ='" + product.bin_location +
                    "'WHERE product.P_Code = '" + product.P_Code + "'";
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
            return "Data Updated Successfully";
        }
    }
}
