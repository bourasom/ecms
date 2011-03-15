/**
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.services.chars;



/**
 *  Author : Nhu Dinh Thuan
 *          Email:nhudinhthuan@yahoo.com
 * Sep 16, 2006
 */
abstract class StringDecoder
{

   private final String requestedCharsetName;

   protected StringDecoder(String requestedCharsetName)
   {
      this.requestedCharsetName = requestedCharsetName;
   }

   final String requestedCharsetName()
   {
      return requestedCharsetName;
   }

   abstract String charsetName();

   abstract char[] decode(byte[] ba, int off, int len);

   int scale(int len, float expansionFactor)
   {
      return (int)(len * (double)expansionFactor);
   }

   char[] trim(char[] ca, int len)
   {
      if (len == ca.length)
         return ca;
      char[] tca = new char[len];
      System.arraycopy(ca, 0, tca, 0, len);
      return tca;
   }
}
