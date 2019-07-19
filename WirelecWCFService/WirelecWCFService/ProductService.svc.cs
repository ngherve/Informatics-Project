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
        private static readonly string MyConnection = "server =localhost; Uid=root; password = ;persistsecurityinfo = True; database =Wirelecdatabase; SslMode = none; Convert Zero Datetime=True";

        private MySqlConnection connection = new MySqlConnection(MyConnection);

        public string CreateProduct(Products product)
        {
            try
            {
                connection.Open();
                MySqlCommand cmd = new MySqlCommand("INSERT INTO product(P_Name, P_Price,P_Image, P_Quantity,Supplier_Name, P_Type, W_ID) VALUES(px1,px2, px3, px4, px5, px6, px7)", connection);
                cmd.Parameters.AddWithValue("px1", product.P_Name);
                cmd.Parameters.AddWithValue("px2", product.P_Price);
                cmd.Parameters.AddWithValue("px3", product.P_Image);
                cmd.Parameters.AddWithValue("px4", product.P_Quantity);
                cmd.Parameters.AddWithValue("px6", product.Supplier_Name);
                cmd.Parameters.AddWithValue("px7", product.P_Type);
                cmd.Parameters.AddWithValue("px8", product.W_ID);
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

       

        List<Products> IProductService.GetProducts()
        {
            List<Products> pros = new List<Products>();

            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM PRODUCTS";
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
                    pro.P_Name = dr["productname"].ToString();
                    pro.P_Price = Convert.ToInt32(dr["Price"]);
                    pro.P_Image = dr["proimage"].ToString();
                    pro.P_Quantity = Convert.ToInt32(dr["quantity"]);
                    pro.Supplier_Name = dr["supplierid"].ToString();
                    pro.P_Type =dr["productType"].ToString();
                    pro.W_ID = Convert.ToInt32(dr["warehouseid"]);
                    pros.Add(pro);
                }
            }

            return pros;
        }
    }

        
    }

