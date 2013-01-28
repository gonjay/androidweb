package com.mothin.gonjay.whatweb;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ImagePagerActivity extends Activity{
	private int[] backpic = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_image_pager);
		String[] imageUrls = {
				"file:///android_asset/u=14692668,3523423595&fm=23&gp=0.jpg",
				"file:///android_asset/u=34138624,4082080679&fm=52&gp=0.jpg",
				"file:///android_asset/u=375530421,414588964&fm=52&gp=0.jpg",
				"file:///android_asset/u=439503814,3062756695&fm=52&gp=0.jpg"};
		
		ViewPager pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(new ImagePagerAdapter(imageUrls));
		
	}
	
	private class ImagePagerAdapter extends PagerAdapter {

		private String[] images;
		private LayoutInflater inflater;

		ImagePagerAdapter(String[] images) {
			this.images = images;
			inflater = getLayoutInflater();
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			View rootView = (View) object;
			ImageView imageView = (ImageView) rootView.findViewById(R.id.image);
			BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
			if (drawable != null) {
				Bitmap bitmap = drawable.getBitmap();
				if (bitmap != null) {
					bitmap.recycle();
				}
			}

			((ViewPager) container).removeView(rootView);
		}

		@Override
		public void finishUpdate(View container) {
		}

		@Override
		public int getCount() {
			return images.length;
		}

		@Override
		public Object instantiateItem(View view, int position) {
			final View imageLayout = inflater.inflate(R.layout.item_pager_image, null);
			final TouchImageView imageView = (TouchImageView) imageLayout.findViewById(R.id.image);
			final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);
			imageView.setImageResource(backpic[position]);

			((ViewPager) view).addView(imageLayout, 0);
			return imageLayout;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view.equals(object);
		}

		@Override
		public void restoreState(Parcelable state, ClassLoader loader) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View container) {
		}
	}
}