package com.app.retrofitcity.ux.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.retrofitcity.databinding.CityRowBinding;
import com.app.retrofitcity.ux.model.CityModelItem;

import java.util.List;

public class CityNameAdapter extends RecyclerView.Adapter<CityNameAdapter.CityNameViewHolder> {

	private final List<CityModelItem> cityModelItemList;

	public CityNameAdapter(List<CityModelItem> cityModelItemList) {
		this.cityModelItemList = cityModelItemList;
	}

	@NonNull
	@Override
	public CityNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new CityNameViewHolder(CityRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull CityNameViewHolder holder, int position) {
		CityModelItem item = cityModelItemList.get(position);
		holder.binding.textviewCityName.setText(item.getName());
	}

	@Override
	public int getItemCount() {
		return cityModelItemList.size();
	}

	static class CityNameViewHolder extends RecyclerView.ViewHolder {
		private final CityRowBinding binding;

		public CityNameViewHolder(CityRowBinding binding) {
			super(binding.getRoot());
			this.binding = binding;
		}
	}
}
