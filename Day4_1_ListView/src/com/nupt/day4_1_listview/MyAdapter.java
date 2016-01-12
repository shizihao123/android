package com.nupt.day4_1_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private String names[];
	private Context context;
	private int images[];
	private String signs[];
    
	public MyAdapter(String[] names, Context context, int images[],
			String signs[]) {
		super();
		this.names = names;
		this.context = context;
		this.images = images;
		this.signs = signs;
	}

	/*public MyAdapter(String name[],Context context,String itemName,String sign){
		this.names = name;
		this.context = context;
		this.itemName = itemName;
		this.sign =sign;
	}*/
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getItem(int arg0) {
		return names[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		 ViewHolder holder = null;
		if(view == null){
			view = LayoutInflater.from(context).inflate(R.layout.item, null);
			holder = new ViewHolder();
			holder.image=(ImageView)view.findViewById(R.id.item1);
			holder.name = (TextView)view.findViewById(R.id.name);
			holder.sign = (TextView)view.findViewById(R.id.sign);
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}	
		
		holder.image.setImageResource(images[position]);
		holder.name.setText(names[position]);
		holder.sign.setText(signs[position]);
		return view;
	}
	
	class ViewHolder{
		ImageView image;
		TextView  name;
		TextView  sign;

	}

	

}
