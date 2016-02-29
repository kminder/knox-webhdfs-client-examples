/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.minder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class TrustAllCerts implements X509TrustManager {

  public static SSLContext createInsecureSslContext() throws NoSuchAlgorithmException, KeyManagementException {
    SSLContext sslContext = SSLContext.getInstance( "SSL" );
    sslContext.init( null, new TrustManager[]{ new TrustAllCerts() }, new SecureRandom() );
    return sslContext;
  }

  public void checkClientTrusted( X509Certificate[] x509Certificates, String s ) throws CertificateException {
    // Trust all certificates.
  }

  public void checkServerTrusted( X509Certificate[] x509Certificates, String s ) throws CertificateException {
    // Trust all certificates.
  }

  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }

}
