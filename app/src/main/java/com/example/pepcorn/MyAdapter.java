package com.example.pepcorn;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pepcorn.databinding.DialogBoxBinding;
import com.example.pepcorn.databinding.SingleRowFinanceBinding;
import com.example.pepcorn.retrofitHelper.APIDataModal;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;

public class MyAdapter extends ListAdapter<APIDataModal.DataModal, MyAdapter.ViewHolder> {


    public APIDataModal.Meta meta;

    public static final DiffUtil.ItemCallback<APIDataModal.DataModal> diffCallBack = new DiffUtil.ItemCallback<APIDataModal.DataModal>() {
        @Override
        public boolean areItemsTheSame(@NonNull APIDataModal.DataModal oldItem, @NonNull APIDataModal.DataModal newItem) {
            return Objects.equals(oldItem.getNav(), newItem.getNav());
        }


        @Override
        public boolean areContentsTheSame(@NonNull APIDataModal.DataModal oldItem, @NonNull APIDataModal.DataModal newItem) {
            return oldItem.equals(newItem);
        }
    };
    protected MyAdapter(APIDataModal.Meta meta) {
        super(diffCallBack);
        this.meta = meta;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleRowFinanceBinding binding = SingleRowFinanceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        APIDataModal.DataModal dataModal = getItem(position);
      //  APIDataModal.DataModal dataModal = list.get(position);


        holder.binding.date.setText(dataModal.getDate());
        holder.binding.schemeName.setText(meta.getScheme_name());
        holder.binding.schemeCode.setText(String.valueOf(meta.getScheme_code()));
        holder.binding.nav.setText(String.valueOf(dataModal.getNav()));

        holder.binding.getRoot().setOnClickListener(v -> {
            MaterialAlertDialogBuilder dialogBox = new MaterialAlertDialogBuilder(v.getContext());
            DialogBoxBinding dialogBoxBinding = DialogBoxBinding.inflate(LayoutInflater.from(v.getContext()));
            dialogBox.setView(dialogBoxBinding.getRoot());

            dialogBoxBinding.schemeName.setText(holder.binding.schemeName.getText());
            dialogBoxBinding.schemeName.setSelected(true);
            dialogBoxBinding.schemeCode.setText(holder.binding.schemeCode.getText());
            dialogBoxBinding.date.setText(holder.binding.date.getText());
            dialogBoxBinding.nav.setText(holder.binding.nav.getText());

            dialogBox.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            dialogBox.create().show();

        });

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        SingleRowFinanceBinding binding;
        public ViewHolder(@NonNull SingleRowFinanceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
