﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace WirelecWCFService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IProductService" in both code and config file together.
    [ServiceContract]
    public interface IProductService
    {
        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "CreateProduct ", BodyStyle = WebMessageBodyStyle.WrappedRequest,
           RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string CreateProduct(Products product);

        [OperationContract]
        [WebGet(UriTemplate = "GetProducts")]
        List<Products> GetProducts();

        [OperationContract]
        [WebGet(UriTemplate = "GetProductbyID")]
        Products GetProductbyID();
    }
}
