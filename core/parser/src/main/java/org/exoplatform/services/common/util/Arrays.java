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

package org.exoplatform.services.common.util;

import java.util.Comparator;
import java.util.logging.Logger;


/**
 *  Author : Nhu Dinh Thuan
 *          Email:nhudinhthuan@yahoo.com
 * Oct 10, 2006
 */
public class Arrays
{
   private static Logger log = Logger.getLogger(Arrays.class.getName());

   public static <T> int search(T a[], T key, Comparator<T> compare)
   {
      int low = 0;
      int high = a.length - 1;

      while (low <= high)
      {
         int mid = (low + high) >> 1;
         T t = a[mid];
         int cmp = compare.compare(t, key);

         if (cmp < 0)
            low = mid + 1;
         else if (cmp > 0)
            high = mid - 1;
         else
            return mid;
      }
      return -1;
   }

   private static <T> void sort(T array[], int bot, int up, java.util.Comparator<T> compare)
   {
      int incre = bot;
      int decre = up;
      T mid = array[(incre + decre) / 2];
      while (true)
      {
         while (compare.compare(array[incre], mid) < 0)
            incre++;
         while (compare.compare(array[decre], mid) > 0)
            decre--;
         if (incre > decre)
            break;
         T v = array[incre];
         array[incre] = array[decre];
         array[decre] = v;
         incre++;
         decre--;
      }
      if (bot < decre)
         sort(array, bot, decre, compare);
      if (incre < up)
         sort(array, incre, up, compare);
   }

   public static <T> void sort(T a[], Comparator<T> compare)
   {
      sort(a, 0, a.length - 1, compare);
   }

   public static void main(String[] args)
   {
      Integer[] a = {-8, 4, 8, 3, -2, 0, 1, -1, 7, 2, 2, 4, 6, 9, 1, 5, 3, 8, -9};
      long start = System.currentTimeMillis();
      int time = 100000;
      for (int i = 0; i < time; i++)
      {
         Integer[] b = new Integer[a.length];
         System.arraycopy(a, 0, b, 0, b.length);
         sort(b, new Comparator<Integer>()
         {
            public int compare(Integer i1, Integer i2)
            {
               return i1.compareTo(i2);
            }
         });
      }
      long end = System.currentTimeMillis();
      log.info(" het " + (end - start));

      start = System.currentTimeMillis();
      for (int i = 0; i < time; i++)
      {
         Integer[] b = new Integer[a.length];
         System.arraycopy(a, 0, b, 0, b.length);
         java.util.Arrays.sort(b, new Comparator<Integer>()
         {
            public int compare(Integer i1, Integer i2)
            {
               return i1.compareTo(i2);
            }
         });
      }
      end = System.currentTimeMillis();
      log.info(" het " + (end - start));
   }

}

